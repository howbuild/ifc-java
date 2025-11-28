package com.howbuild.ifc;

import static java.util.Collections.*;

import com.howbuild.ifc.v4.BaseIfc;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class IfcModel {
  private IfcHeader header;
  private Map<Integer, BaseIfc> entitiesById;

  public static IfcModel read(InputStream input) throws Exception {
    if (input == null) throw new IllegalArgumentException("input is null");
    return new IfcStepDeserializer().read(input);
  }

  public IfcHeader getHeader() {
    return header;
  }

  public void setHeader(IfcHeader header) {
    this.header = header;
  }

  public Map<Integer, BaseIfc> getEntitiesById() {
    return entitiesById;
  }

  public void setEntitiesById(Map<Integer, BaseIfc> entitiesById) {
    this.entitiesById = entitiesById;
  }

  public BaseIfc byId(int id) {
    return entitiesById.get(id);
  }

  public <T> List<T> getCollection(Class<T> clazz) {
    return (List<T>)
        entitiesById.values().stream()
            .filter(x -> clazz.isAssignableFrom(x.getClass()))
            .collect(Collectors.toList());
  }

  public List<BaseIfc> byType(String simpleName) {
    if (entitiesById == null) return Collections.emptyList();
    String target = simpleName.toUpperCase();
    return entitiesById.values().stream()
        .filter(e -> e != null && e.getClass().getSimpleName().toUpperCase().equals(target))
        .collect(Collectors.toList());
  }

  public Set<String> types() {
    if (entitiesById == null) return Collections.emptySet();
    return entitiesById.values().stream()
        .filter(Objects::nonNull)
        .map(x -> x.getClass().getSimpleName())
        .collect(Collectors.toSet());
  }

  public BaseIfc byGuid(String guid) {
    if (guid == null || entitiesById == null) return null;
    for (BaseIfc e : entitiesById.values()) {
      Object g = tryGetGlobalId(e);
      if (g != null && guid.equals(g.toString())) return e;
    }
    return null;
  }

  private Object tryGetGlobalId(BaseIfc e) {
    try {
      Method m = e.getClass().getMethod("getGlobalId");
      Object gid = m.invoke(e);
      if (gid == null) return null;
      try {
        Method gv = gid.getClass().getMethod("getValue");
        return gv.invoke(gid);
      } catch (Exception ignore) {
        return gid;
      }
    } catch (Exception ex) {
      return null;
    }
  }

  public List<BaseIfc> traverse(BaseIfc root, int maxDepth) {
    List<BaseIfc> out = new ArrayList<>();
    java.util.Set<BaseIfc> seen = newSetFromMap(new IdentityHashMap<>());
    java.util.Deque<TraverseNode> dq = new java.util.ArrayDeque<>();
    dq.add(new TraverseNode(root, 0));
    while (!dq.isEmpty()) {
      TraverseNode n = dq.removeFirst();
      if (n.obj == null || seen.contains(n.obj)) continue;
      seen.add(n.obj);
      out.add(n.obj);
      if (maxDepth >= 0 && n.depth >= maxDepth) continue;
      for (BaseIfc child : directRefs(n.obj)) {
        dq.add(new TraverseNode(child, n.depth + 1));
      }
    }
    return out;
  }

  public List<BaseIfc> traverse(BaseIfc root) {
    return traverse(root, -1);
  }

  private List<BaseIfc> directRefs(BaseIfc obj) {
    List<BaseIfc> out = new ArrayList<>();
    for (java.lang.reflect.Field f : obj.getClass().getDeclaredFields()) {
      f.setAccessible(true);
      try {
        Object v = f.get(obj);
        if (v instanceof BaseIfc) out.add((BaseIfc) v);
        else if (v instanceof java.util.Collection<?>) {
          for (Object o : (java.util.Collection<?>) v) {
            if (o instanceof BaseIfc) out.add((BaseIfc) o);
          }
        }
      } catch (IllegalAccessException ignore) {
      }
    }
    return out;
  }

  public List<BaseIfc> getInverse(BaseIfc target) {
    if (entitiesById == null || target == null) return emptyList();
    List<BaseIfc> out = new ArrayList<>();
    for (BaseIfc e : entitiesById.values()) {
      if (e == null) continue;
      if (references(e, target)) out.add(e);
    }
    return out;
  }

  private boolean references(BaseIfc holder, BaseIfc target) {
    for (BaseIfc ref : directRefs(holder)) {
      if (ref == target) return true;
    }
    return false;
  }

  public BaseIfc add(BaseIfc e) {
    if (entitiesById == null) {
      entitiesById = new java.util.HashMap<>();
    }
    int nextId = entitiesById.keySet().stream().mapToInt(Integer::intValue).max().orElse(0) + 1;
    e.setStepId(nextId);
    entitiesById.put(nextId, e);
    return e;
  }

  public void remove(BaseIfc e) {
    if (entitiesById == null || e == null) return;
    entitiesById.values().removeIf(x -> x == e);
  }

  private static class TraverseNode {
    final BaseIfc obj;
    final int depth;

    TraverseNode(BaseIfc o, int d) {
      obj = o;
      depth = d;
    }
  }
}
