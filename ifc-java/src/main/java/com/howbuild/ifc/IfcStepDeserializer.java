package com.howbuild.ifc;

import com.howbuild.ifc.v4.BaseIfc;
import com.howbuild.ifc.v4.IfcRegistry;
import com.howbuild.ifc.v4.SimpleType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IfcStepDeserializer implements IfcDeserializer {
  private BaseIfc[] entityCache;
  private DataStepEntity[] dataCache;
  private int maxId = 0;
  private int lineNumber = 1;

  @Override
  public IfcModel read(InputStream input) throws Exception {
    IfcModel model = new IfcModel();
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
    List<StepEntity> headerEntities = new ArrayList<>();
    try {
      String statement;
      while ((statement = readNextStatement(reader)) != null) {
        if (statement.startsWith("HEADER;")) {
          headerEntities = processHeader(reader);
        } else if (statement.startsWith("DATA;")) {
          List<DataStepEntity> tempData = processData(reader);

          // allocate caches based on maximum id seen
          dataCache = new DataStepEntity[maxId + 1];
          entityCache = new BaseIfc[maxId + 1];
          for (DataStepEntity d : tempData) {
            dataCache[d.entityNo] = d;
          }

          // Phase 1: allocate empty shells
          for (int id = 1; id <= maxId; id++) {
            DataStepEntity d = dataCache[id];
            if (d == null) continue;
            BaseIfc shell = IfcRegistry.newInstance(d.entity.getName());
            if (shell == null)
              throw new IfcDeserializeException("Unknown entity " + d.entity.getName());
            shell.setStepId(id);
            entityCache[id] = shell;
          }

          // Phase 2: populate attributes and finalize relationships (ATTR_TYPES 불필요)
          for (int id = 1; id <= maxId; id++) {
            DataStepEntity d = dataCache[id];
            if (d == null) continue;
            BaseIfc target = entityCache[id];
            IfcRegistry.AttrMeta[] meta = IfcRegistry.getAttrMeta(d.entity.getName());
            List<Object> vals = materializeArgs(meta, d.entity.getArgs());
            IfcRegistry.populate(d.entity.getName(), target, vals);
          }
        }
      }
    } catch (Exception e) {
      throw new IfcDeserializeException("Error at line " + lineNumber + " : " + e.getMessage(), e);
    }

    Map<Integer, BaseIfc> mapView = new HashMap<>();
    if (entityCache != null) {
      for (int i = 1; i < entityCache.length; i++) {
        if (entityCache[i] != null) {
          mapView.put(i, entityCache[i]);
        }
      }
    }
    model.setEntitiesById(mapView);
    return model;
  }

  /**
   * Reads physical lines until a STEP statement (terminated by ';') is complete. Comments and empty
   * lines are skipped. The method keeps track of the physical line numbers for diagnostics.
   */
  private String readNextStatement(BufferedReader reader) throws IOException {
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
      lineNumber++;
      String trimmed = line.trim();
      if (trimmed.isEmpty() || trimmed.startsWith("/") || trimmed.startsWith("*")) {
        continue;
      }

      sb.append(trimmed);
      int endIdx = sb.lastIndexOf(";");
      if (endIdx != -1) {
        return sb.substring(0, endIdx + 1);
      }
    }

    return sb.length() == 0 ? null : sb.toString();
  }

  private List<StepEntity> processHeader(BufferedReader reader) throws IOException {
    try {
      List<StepEntity> entities = new ArrayList<>();
      String statement;
      while ((statement = readNextStatement(reader)) != null) {
        if (statement.startsWith("ENDSEC;")) {
          return entities;
        }

        StepEntity e = StepParser.parse(statement);
        entities.add(e);
      }

      return entities;
    } catch (Exception e) {
      throw new IfcDeserializeException("Error at line " + lineNumber + " : " + e.getMessage());
    }
  }

  private List<DataStepEntity> processData(BufferedReader reader) {
    List<DataStepEntity> temp = new ArrayList<>();
    try {
      String statement;
      while ((statement = readNextStatement(reader)) != null) {
        if (statement.startsWith("ENDSEC;")) {
          return temp;
        }

        int equalsIdx = statement.indexOf('=');
        int hashIdx = statement.indexOf('#');
        if (equalsIdx < 0 || hashIdx < 0 || hashIdx > equalsIdx) {
          throw new IfcDeserializeException("Malformed entity line: " + statement);
        }

        String idText = statement.substring(hashIdx + 1, equalsIdx).trim();
        int no = Integer.parseInt(idText);
        if (no > maxId) {
          maxId = no;
        }
        // Remove trailing semicolon if present
        String entityLine = statement.substring(equalsIdx + 1).trim();
        if (entityLine.endsWith(";")) {
          entityLine = entityLine.substring(0, entityLine.length() - 1);
        }

        StepEntity e = StepParser.parse(entityLine);
        temp.add(new DataStepEntity(no, e));
      }
    } catch (Exception e) {
      throw new IfcDeserializeException("Error at line " + lineNumber + " : " + e.getMessage());
    }
    return temp;
  }

  private static String capitalize(String name) {
    if (name == null || name.isEmpty()) return name;
    String[] parts = name.split("\\.");
    String last = parts[parts.length - 1];
    return Character.toUpperCase(last.charAt(0)) + last.substring(1);
  }

  public Object create(Class clazz, StepToken arg) {
    try {
      if (arg.getType() == StepTokenType.EMPTY || arg.getType() == StepTokenType.UNKNOWN) {
        return null;
      }

      if (SimpleType.class.isAssignableFrom(clazz)) {
        return createSimpleType(clazz, arg);
      }
      if (clazz.isAssignableFrom(arg.getLiteral().getClass())) {
        return arg.getLiteral();
      }

      switch (arg.getType()) {
        case STRING:
          if (clazz.isAssignableFrom(String.class)) return arg.getLiteral();
          throw new IfcDeserializeException("Cannot assign STRING to " + clazz.getSimpleName());
        case ENUM:
          if (clazz.isEnum()) {
            return Enum.valueOf((Class<Enum>) clazz, arg.getLiteral().toString());
          }
          if (clazz.isAssignableFrom(String.class)) return arg.getLiteral();
          throw new IfcDeserializeException("Cannot assign ENUM to " + clazz.getSimpleName());
        case LOGICAL:
          com.howbuild.ifc.v4.IfcLogicalValue lv =
              (com.howbuild.ifc.v4.IfcLogicalValue) arg.getLiteral();
          if (clazz == com.howbuild.ifc.v4.IfcLogicalValue.class) return lv;
          if (clazz == boolean.class || clazz == Boolean.class) {
            if (lv == com.howbuild.ifc.v4.IfcLogicalValue.UNKNOWN) return null;
            return lv == com.howbuild.ifc.v4.IfcLogicalValue.TRUE;
          }
          throw new IfcDeserializeException("Cannot assign LOGICAL to " + clazz.getSimpleName());
        case BOOLEAN:
          if (clazz == boolean.class || clazz == Boolean.class) return arg.getLiteral();
          throw new IfcDeserializeException("Cannot assign BOOLEAN to " + clazz.getSimpleName());
        case ENTITY:
          List<StepToken> entityArgs = (List<StepToken>) arg.getLiteral();
          BaseIfc inlineShell = IfcRegistry.newInstance(arg.getName());
          if (inlineShell == null)
            throw new IfcDeserializeException("Unknown inline entity " + arg.getName());
          IfcRegistry.AttrMeta[] meta = IfcRegistry.getAttrMeta(arg.getName());
          List<Object> vals = materializeArgs(meta, entityArgs);
          IfcRegistry.populate(arg.getName(), inlineShell, vals);
          return inlineShell;
        case INTEGER:
          return convertNumber(clazz, (Number) arg.getLiteral());
        case REAL:
          return convertNumber(clazz, (Number) arg.getLiteral());
        case REF:
          int id = (Integer) arg.getLiteral();
          if (id <= 0 || id >= entityCache.length || entityCache[id] == null) {
            throw new IfcDeserializeException("Reference #" + id + " out of range or missing");
          }
          return entityCache[id];
      }
      return null;
    } catch (Exception e) {
      throw new IfcDeserializeException("create error", e);
    }
  }

  private List<Object> materializeArgs(IfcRegistry.AttrMeta[] meta, List<StepToken> tokens) {
    if (meta == null) throw new IfcDeserializeException("No metadata for entity");
    List<Object> out = new ArrayList<>(meta.length);
    for (int i = 0; i < meta.length; i++) {
      IfcRegistry.AttrMeta m = meta[i];
      StepToken tok = i < tokens.size() ? tokens.get(i) : new StepToken(StepTokenType.EMPTY);
      out.add(m.depth == 0 ? create(m.base, tok) : createCollection(m.base, tok, m.depth));
    }
    return out;
  }

  private Object createCollection(Class elemClazz, StepToken arg, int depth) {
    if (arg.getType() == StepTokenType.EMPTY || arg.getType() == StepTokenType.UNKNOWN) return null;
    if (arg.getType() != StepTokenType.SET) throw new IfcDeserializeException("Expected SET token");
    List<StepToken> tokList = (List<StepToken>) arg.getLiteral();
    List<Object> out = new ArrayList<>();
    if (depth == 1) {
      for (StepToken t : tokList) out.add(create(elemClazz, t));
    } else {
      for (StepToken t : tokList) out.add(createCollection(elemClazz, t, depth - 1));
    }
    return out;
  }

  private Object createSimpleType(Class<?> clazz, StepToken arg) {
    try {
      if (arg.getLiteral() == null
          || arg.getType() == StepTokenType.EMPTY
          || arg.getType() == StepTokenType.UNKNOWN) {
        return null;
      }
      BaseIfc inst = IfcRegistry.newInstance(clazz.getSimpleName());
      if (!(inst instanceof SimpleType))
        throw new IfcDeserializeException("Not a simple type " + clazz.getSimpleName());
      IfcRegistry.AttrMeta[] meta = IfcRegistry.getAttrMeta(clazz.getSimpleName());
      if (meta == null || meta.length != 1)
        throw new IfcDeserializeException("Missing meta for simple type " + clazz.getSimpleName());
      Object v =
          meta[0].depth == 0
              ? create(meta[0].base, arg)
              : createCollection(meta[0].base, arg, meta[0].depth);
      ((SimpleType) inst).setValue(v);
      return inst;
    } catch (Exception e) {
      throw new IfcDeserializeException("create simple type error", e);
    }
  }

  private Object convertNumber(Class clazz, Number num) {
    if (clazz == Double.class || clazz == double.class) return num.doubleValue();
    if (clazz == Float.class || clazz == float.class) return num.floatValue();
    if (clazz == Long.class || clazz == long.class) return num.longValue();
    if (clazz == Integer.class || clazz == int.class) return num.intValue();
    if (clazz == Short.class || clazz == short.class) return num.shortValue();
    if (clazz == Byte.class || clazz == byte.class) return num.byteValue();
    return num;
  }

  private static class DataStepEntity {
    private final int entityNo;
    private final StepEntity entity;

    public DataStepEntity(int entityNo, StepEntity entity) {
      this.entityNo = entityNo;
      this.entity = entity;
    }
  }
}
