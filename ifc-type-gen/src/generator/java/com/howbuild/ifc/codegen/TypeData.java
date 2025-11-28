package com.howbuild.ifc.codegen;

import java.util.List;

/** Base class for all schema type metadata containers. */
public abstract class TypeData {
  protected JavaLanguageGenerator generator;

  public TypeData(String name, String schema, JavaLanguageGenerator generator) {
    this.generator = generator;
    Schema = schema;
    Name = name;
  }

  public String Name;
  public String Schema;
}

class TypeReference {
  protected JavaLanguageGenerator generator;
  protected String type;
  public final boolean IsCollection;
  public final int Rank;
  public final boolean IsGeneric;

  public TypeReference(
      JavaLanguageGenerator generator,
      String type,
      boolean isCollection,
      int rank,
      boolean isGeneric) {
    this.generator = generator;
    this.type = type;
    this.IsCollection = isCollection;
    this.Rank = rank;
    this.IsGeneric = isGeneric;
  }

  public String getType() {
    return generator.AttributeDataType(IsCollection, Rank, type, IsGeneric);
  }

  public String getRawType() {
    return type;
  }
}

class ParameterData extends TypeReference {
  public String Name;

  public ParameterData(
      JavaLanguageGenerator generator,
      String name,
      boolean isCollection,
      int rank,
      boolean isGeneric,
      String type) {
    super(generator, type, isCollection, rank, isGeneric);
    this.Name = name;
  }

  public String getParameterName() {
    String name = Name;
    if ("Operator".equals(name)) name = "op";
    return Character.toLowerCase(name.charAt(0)) + name.substring(1);
  }
}

class AttributeData extends ParameterData {
  public final boolean IsDerived;
  public final boolean IsOptional;
  public final boolean IsInverse;
  public final boolean HidesParentAttributeOfSameName;

  public AttributeData(
      JavaLanguageGenerator generator,
      String name,
      String type,
      int rank,
      boolean isCollection,
      boolean isGeneric,
      boolean isDerived,
      boolean isOptional,
      boolean isInverse) {
    super(generator, name, isCollection, rank, isGeneric, type);
    IsDerived = isDerived;
    IsOptional = isOptional;
    IsInverse = isInverse;

    if (isDerived && Name.contains("SELF\\")) {
      HidesParentAttributeOfSameName = true;
      Name = Name.substring(Name.lastIndexOf('.') + 1);
    } else {
      HidesParentAttributeOfSameName = false;
    }
  }

  @Override
  public String toString() {
    return generator.AttributeDataString(this);
  }

  public String toStepString(boolean isDerivedInChild) {
    return generator.AttributeStepString(this, isDerivedInChild);
  }
}

class FunctionData {
  public String Name;
  public List<ParameterData> Parameters;
  public TypeReference ReturnType;

  public FunctionData(String name, TypeReference returnType, List<ParameterData> parameters) {
    Name = name;
    Parameters = parameters;
    ReturnType = returnType;
  }
}

abstract class CollectionTypeData extends TypeData {
  public final List<String> Values;

  public CollectionTypeData(
      String name, String schema, JavaLanguageGenerator generator, List<String> values) {
    super(name, schema, generator);
    this.Values = values;
  }
}

class WrapperType extends TypeData {
  public final boolean IsCollectionType;
  public final int Rank;
  public final String WrappedType;

  public WrapperType(
      String name,
      String schema,
      String wrappedType,
      JavaLanguageGenerator generator,
      boolean isCollectionType,
      int rank) {
    super(name, schema, generator);
    IsCollectionType = isCollectionType;
    Rank = rank;
    WrappedType = wrappedType;
  }

  @Override
  public String toString() {
    return generator.SimpleTypeString(this);
  }
}

class EnumType extends CollectionTypeData {
  public EnumType(
      String name, String schema, JavaLanguageGenerator generator, List<String> values) {
    super(name, schema, generator, values);
  }

  @Override
  public String toString() {
    return generator.EnumTypeString(this);
  }
}

class SelectType extends CollectionTypeData {
  public SelectType(
      String name, String schema, JavaLanguageGenerator generator, List<String> values) {
    super(name, schema, generator, values);
  }

  @Override
  public String toString() {
    return generator.SelectTypeString(this);
  }
}

class InverseAttr {
  public final String entityName;
  public final String name;
  public final String inverseType;
  public final String inverseAttrName;

  public InverseAttr(String entityName, String name, String inverseType, String inverseAttrName) {
    this.entityName = entityName;
    this.name = name;
    this.inverseType = inverseType;
    this.inverseAttrName = inverseAttrName;
  }
}

class Entity extends TypeData {
  public List<Entity> Supers;
  public List<Entity> Subs;
  public List<AttributeData> Attributes;
  public boolean IsAbstract;

  public Entity(String name, String schema, JavaLanguageGenerator generator) {
    super(name, schema, generator);
    Supers = new java.util.ArrayList<>();
    Subs = new java.util.ArrayList<>();
    Attributes = new java.util.ArrayList<>();
  }

  public Iterable<Entity> Parents() {
    java.util.List<Entity> parents = new java.util.ArrayList<>();
    for (Entity sup : Supers) {
      for (Entity p : sup.Parents()) parents.add(p);
      parents.add(sup);
    }
    return parents;
  }

  public Iterable<Entity> ParentsAndSelf() {
    java.util.List<Entity> parents = new java.util.ArrayList<>();
    for (Entity sup : Supers) {
      for (Entity p : sup.ParentsAndSelf()) parents.add(p);
    }
    parents.add(this);
    return parents;
  }

  public boolean IsTypeOrSubtypeOfEntity(String typeName) {
    if (Name.equals(typeName)) return true;
    for (Entity s : Subs) {
      if (s.IsTypeOrSubtypeOfEntity(typeName)) return true;
    }
    return false;
  }

  public String Fields() {
    java.util.List<AttributeData> attrs = Attributes;
    if (attrs.isEmpty()) return "";
    StringBuilder b = new StringBuilder();
    for (AttributeData a : attrs) {
      String field = generator.AttributeFieldString(a);
      if (!field.isEmpty()) b.append(field).append("\n");
    }
    return b.toString();
  }

  public String Accessors() {
    java.util.List<AttributeData> attrs = Attributes;
    if (attrs.isEmpty()) return "";
    StringBuilder b = new StringBuilder();
    for (AttributeData a : attrs) {
      String acc = generator.AttributeAccessorString(a);
      if (!acc.isEmpty()) b.append(acc).append("\n");
    }
    return b.toString();
  }

  public String StepProperties() {
    java.util.List<AttributeData> attrs = new java.util.ArrayList<>();
    for (Entity e : ParentsAndSelf()) {
      for (AttributeData a : e.Attributes) {
        if (!a.IsInverse && !a.IsDerived) attrs.add(a);
      }
    }
    java.util.List<AttributeData> derAttrs = new java.util.ArrayList<>();
    for (Entity e : ParentsAndSelf()) {
      for (AttributeData a : e.Attributes) {
        if (!a.IsInverse && a.IsDerived && a.HidesParentAttributeOfSameName) derAttrs.add(a);
      }
    }
    if (attrs.isEmpty()) return "";
    StringBuilder b = new StringBuilder();
    for (AttributeData a : attrs) {
      boolean isDerivedInChild = false;
      for (AttributeData d : derAttrs) {
        if (d.Name.equals(a.Name)) {
          isDerivedInChild = true;
          break;
        }
      }
      String prop = a.toStepString(isDerivedInChild);
      if (!prop.isEmpty()) b.append(prop).append("\n");
    }
    return b.toString();
  }

  @Override
  public String toString() {
    return generator.EntityString(this);
  }
}
