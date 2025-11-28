package com.howbuild.ifc;

import static org.junit.jupiter.api.Assertions.*;

import com.howbuild.ifc.v4.BaseIfc;
import com.howbuild.ifc.v4.IfcLogicalValue;
import com.howbuild.ifc.v4.SimpleType;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

public class IfcStepDeserializerTest {

  private IfcModel parse(String path) throws Exception {
    try (InputStream in = new FileInputStream(path)) {
      return new IfcStepDeserializer().read(in);
    }
  }

  @Test
  public void parseMediumHouseModel() throws Exception {
    String file = "src/test/resources/ifc/AC20-FZK-Haus.ifc";
    IfcModel v1 = parse(file);
    int count = v1.getEntitiesById().size();
    assertTrue(count > 0, "entity count should be > 0");
  }

  @Test
  public void parseIssue005Haus() throws Exception {
    String file = "src/test/resources/ifc/haus.ifc";
    IfcModel v1 = parse(file);
    int count = v1.getEntitiesById().size();
    assertTrue(count > 100, "entity count should be > 100");
    assertTrue(
        countMatchingAny(v1, "IfcWall", "IfcWallStandardCase", "IfcBuilding") > 0,
        "should contain walls/building");
  }

  @Test
  public void normalizedJsonReportContainsExpectedValues() throws Exception {
    // Parse fixture
    IfcModel model = parse("src/test/resources/ifc/wall-with-opening-and-window.ifc");

    // Check project basics
    Map<String, Object> project = normalizeEntity(model, 1);
    Map<String, Object> projAttrs = castMap(project.get("attrs"));
    assertEquals("IfcProject", project.get("type"));
    assertEquals("Default Project", project.get("name"));
    assertEquals("28hypXUBvBefc20SI8kfA$", projAttrs.get("GlobalId"));
    assertEquals("Description of Default Project", projAttrs.get("Description"));

    // Geometry context
    Map<String, Object> ctx = normalizeEntity(model, 20);
    Map<String, Object> ctxAttrs = castMap(ctx.get("attrs"));
    assertEquals(3, ((Number) ctxAttrs.get("CoordinateSpaceDimension")).intValue());
    assertEquals("Model", ctxAttrs.get("ContextType"));
    assertEquals(
        "Curve2D",
        ((Map<String, Object>) normalizeEntity(model, 66).get("attrs")).get("RepresentationType"));

    // Building + placement reference
    Map<String, Object> bldg = normalizeEntity(model, 34);
    Map<String, Object> bldgAttrs = castMap(bldg.get("attrs"));
    assertEquals("IfcBuilding", bldg.get("type"));
    assertEquals("Default Building", bldg.get("name"));
    assertEquals("0AqAhXVxvCy9m0OX1nxY1A", bldgAttrs.get("GlobalId"));
    Map<String, Object> placementRef = castMap(bldgAttrs.get("ObjectPlacement"));
    assertEquals(35, ((Number) placementRef.get("ref")).intValue());

    // Axis placement coordinates
    Map<String, Object> axis = normalizeEntity(model, 40);
    Map<String, Object> axisAttrs = castMap(axis.get("attrs"));
    Map<String, Object> locRef = castMap(axisAttrs.get("Location"));
    assertEquals(24, ((Number) locRef.get("ref")).intValue());

    // Direction and placement chain (TrueNorth and nested LocalPlacement)
    Map<String, Object> trueNorth = normalizeEntity(model, 23);
    List<Double> dir = castList(castMap(trueNorth.get("attrs")).get("DirectionRatios"));
    assertEquals(java.util.Arrays.asList(0.0, 1.0), dir);

    Map<String, Object> localPlacement = normalizeEntity(model, 35);
    Map<String, Object> relPlacement =
        castMap(castMap(localPlacement.get("attrs")).get("RelativePlacement"));
    assertEquals(36, ((Number) relPlacement.get("ref")).intValue());
    Map<String, Object> relAxis = normalizeEntity(model, 36);
    Map<String, Object> relAxisAttrs = castMap(relAxis.get("attrs"));
    Map<String, Object> relLocRef = castMap(relAxisAttrs.get("Location"));
    assertEquals(24, ((Number) relLocRef.get("ref")).intValue());

    // Aggregation relationship
    Map<String, Object> relAgg = normalizeEntity(model, 43);
    Map<String, Object> relAttrs = castMap(relAgg.get("attrs"));
    assertEquals("ProjectContainer", relAgg.get("name"));
    Map<String, Object> relObj = castMap(relAttrs.get("RelatingObject"));
    assertEquals(1, ((Number) relObj.get("ref")).intValue());

    // Shape representation -> polyline -> points
    Map<String, Object> shp = normalizeEntity(model, 66);
    Map<String, Object> shpAttrs = castMap(shp.get("attrs"));
    List<Map<String, Object>> items = castList(shpAttrs.get("Items"));
    assertEquals(1, items.size());
    assertEquals(67, ((Number) items.get(0).get("ref")).intValue());

    Map<String, Object> pline = normalizeEntity(model, 67);
    List<Map<String, Object>> pts = castList(castMap(pline.get("attrs")).get("Points"));
    assertEquals(2, pts.size());
    assertEquals(68, ((Number) pts.get(0).get("ref")).intValue());
    assertEquals(69, ((Number) pts.get(1).get("ref")).intValue());

    Map<String, Object> p1 = normalizeEntity(model, 68);
    Map<String, Object> p1Attrs = castMap(p1.get("attrs"));
    assertEquals(java.util.Arrays.asList(0.0, 150.0), p1Attrs.get("Coordinates"));

    Map<String, Object> p2 = normalizeEntity(model, 69);
    Map<String, Object> p2Attrs = castMap(p2.get("attrs"));
    assertEquals(java.util.Arrays.asList(3000.0, 150.0), p2Attrs.get("Coordinates"));
  }

  // ---- helpers for normalization ----

  private static Map<String, Object> normalizeSubset(IfcModel model, java.util.Set<Integer> ids) {
    List<BaseIfc> entities = new ArrayList<>(model.getEntitiesById().values());
    entities.removeIf(Objects::isNull);
    entities.sort(Comparator.comparingInt(BaseIfc::getStepId));

    Map<String, Integer> byType = new TreeMap<>();
    List<Map<String, Object>> records = new ArrayList<>();
    for (BaseIfc e : entities) {
      if (!ids.contains(e.getStepId())) continue;
      String type = e.getClass().getSimpleName();
      byType.put(type, byType.getOrDefault(type, 0) + 1);

      Map<String, Object> rec = new LinkedHashMap<>();
      rec.put("id", e.getStepId());
      rec.put("type", type);
      rec.put("global_id", extractString(e, "getGlobalId"));
      rec.put("name", extractString(e, "getName"));
      rec.put("attrs", extractAttributes(e));
      records.add(rec);
    }

    Map<String, Object> payload = new LinkedHashMap<>();
    payload.put("entity_count", records.size());
    payload.put("by_type", byType);
    payload.put("entities", records);
    return payload;
  }

  private static Map<String, Object> extractAttributes(BaseIfc obj) {
    Map<String, Object> out = new LinkedHashMap<>();
    for (Field f : allFields(obj.getClass())) {
      if (Modifier.isStatic(f.getModifiers())) continue;
      if (f.getName().equals("stepId")) continue;
      f.setAccessible(true);
      try {
        Object v = f.get(obj);
        out.put(capitalize(f.getName()), normalizeValue(v));
      } catch (Exception ignore) {
      }
    }
    return out;
  }

  private static List<Field> allFields(Class<?> cls) {
    List<Field> out = new ArrayList<>();
    Class<?> c = cls;
    while (c != null && BaseIfc.class.isAssignableFrom(c)) {
      for (Field f : c.getDeclaredFields()) out.add(f);
      c = c.getSuperclass();
    }
    return out;
  }

  private static Object normalizeValue(Object v) {
    if (v == null) return null;
    if (v instanceof SimpleType) return normalizeValue(((SimpleType) v).getValue());
    if (v instanceof BaseIfc) {
      BaseIfc b = (BaseIfc) v;
      Map<String, Object> ref = new LinkedHashMap<>();
      ref.put("ref", b.getStepId());
      ref.put("type", b.getClass().getSimpleName());
      ref.put("global_id", extractString(b, "getGlobalId"));
      return ref;
    }
    if (v.getClass().isEnum()) {
      if (v instanceof IfcLogicalValue) {
        IfcLogicalValue lv = (IfcLogicalValue) v;
        if (lv == IfcLogicalValue.TRUE) return Boolean.TRUE;
        if (lv == IfcLogicalValue.FALSE) return Boolean.FALSE;
        return "UNKNOWN";
      }
      return ((Enum<?>) v).name();
    }
    if (v instanceof java.util.Map<?, ?>) {
      Map<Object, Object> m = (Map<Object, Object>) v;
      Map<Object, Object> out = new LinkedHashMap<>();
      for (Map.Entry<Object, Object> e : m.entrySet())
        out.put(e.getKey(), normalizeValue(e.getValue()));
      return out;
    }
    if (v instanceof Iterable<?>) {
      List<Object> out = new ArrayList<>();
      for (Object o : (Iterable<?>) v) out.add(normalizeValue(o));
      return out;
    }
    if (v.getClass().isArray()) {
      int len = java.lang.reflect.Array.getLength(v);
      List<Object> out = new ArrayList<>(len);
      for (int i = 0; i < len; i++) out.add(normalizeValue(java.lang.reflect.Array.get(v, i)));
      return out;
    }
    if (v instanceof Number || v instanceof CharSequence || v instanceof Boolean) return v;
    return String.valueOf(v);
  }

  private static String extractString(BaseIfc obj, String getter) {
    try {
      Object value = obj.getClass().getMethod(getter).invoke(obj);
      Object primitive = normalizeValue(value);
      return primitive == null ? null : primitive.toString();
    } catch (Exception ignore) {
      return null;
    }
  }

  private static String capitalize(String name) {
    if (name == null || name.isEmpty()) return name;
    return Character.toUpperCase(name.charAt(0)) + name.substring(1);
  }

  private long countMatchingAny(IfcModel model, String... typeNames) {
    return model.getEntitiesById().values().stream()
        .filter(
            e -> {
              String simple = e.getClass().getSimpleName();
              for (String t : typeNames) if (simple.equals(t)) return true;
              return false;
            })
        .count();
  }

  @SuppressWarnings("unchecked")
  private static <T> List<T> castList(Object o) {
    return (List<T>) o;
  }

  @SuppressWarnings("unchecked")
  private static <K, V> Map<K, V> castMap(Object o) {
    return (Map<K, V>) o;
  }

  @SuppressWarnings("unchecked")
  private static Map<String, Object> normalizeEntity(IfcModel model, int id) {
    List<Map<String, Object>> ents =
        castList(normalizeSubset(model, java.util.Collections.singleton(id)).get("entities"));
    for (Map<String, Object> e : ents) {
      if (((Number) e.get("id")).intValue() == id) return e;
    }
    throw new AssertionError("Missing entity " + id);
  }
}
