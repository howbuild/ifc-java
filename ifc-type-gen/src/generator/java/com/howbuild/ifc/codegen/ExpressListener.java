package com.howbuild.ifc.codegen;

import com.howbuild.ifc.express.ExpressBaseListener;
import com.howbuild.ifc.express.ExpressParser;
import com.howbuild.ifc.express.ExpressParser.*;
import java.util.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

public class ExpressListener extends ExpressBaseListener {
  private final JavaLanguageGenerator generator;

  public ExpressListener(JavaLanguageGenerator generator) {
    this.generator = generator;
  }

  public Map<String, TypeData> TypeData = new HashMap<>();
  public Map<String, List<String>> InversedTypeData = new HashMap<>();
  public Map<String, FunctionData> FunctionData = new HashMap<>();
  public Map<String, List<InverseAttr>> InverseAttrData = new HashMap<>();

  @Override
  public void enterSchemaDecl(ExpressParser.SchemaDeclContext context) {}

  private String GetSchema(ParserRuleContext context) {
    return context
        .start
        .getInputStream()
        .getText(new Interval(context.start.getStartIndex(), context.stop.getStopIndex()));
  }

  // TYPE
  @Override
  public void enterTypeBody(ExpressParser.TypeBodyContext context) {
    String name = context.typeDef().SimpleId().getText();

    TypeData td = null;
    RefInt rank = new RefInt(0);
    RefBoolean returnsCollection = new RefBoolean(false);
    RefBoolean isGeneric = new RefBoolean(false);

    if (context.typeSel().collectionType() != null) {
      String wrappedType =
          ParseCollectionType(
              context.typeSel().collectionType(), rank, returnsCollection, isGeneric);
      td =
          new WrapperType(
              name,
              GetSchema(context),
              wrappedType,
              generator,
              returnsCollection.value,
              rank.value);
    } else if (context.typeSel().simpleType() != null) {
      String wrappedType = ParseSimpleType(context.typeSel().simpleType());
      td =
          new WrapperType(
              name,
              GetSchema(context),
              wrappedType,
              generator,
              returnsCollection.value,
              rank.value);
    } else if (context.typeSel().namedType() != null) {
      String wrappedType = ParseNamedType(context.typeSel().namedType());
      td =
          new WrapperType(
              name,
              GetSchema(context),
              wrappedType,
              generator,
              returnsCollection.value,
              rank.value);
    } else if (context.typeSel().enumType() != null) {
      String[] values = context.typeSel().enumType().enumValues().getText().split(",");
      td = new EnumType(name, GetSchema(context), generator, Arrays.asList(values));
    } else if (context.typeSel().selectType() != null) {
      String[] values = context.typeSel().selectType().selectValues().getText().split(",");
      td = new SelectType(name, GetSchema(context), generator, Arrays.asList(values));
    }

    TypeData.put(name, td);
  }

  // ENTITY
  @Override
  public void enterEntityDecl(ExpressParser.EntityDeclContext context) {
    Entity entity;
    String entityName = context.entityHead().entityDef().SimpleId().getText();

    if (TypeData.containsKey(entityName)) {
      entity = (Entity) TypeData.get(entityName);
    } else {
      entity = new Entity(entityName, GetSchema(context), generator);
      TypeData.put(entityName, entity);
    }

    ExpressParser.SubSuperContext subSuper = context.entityHead().subSuper();

    // SUPERTYPE declarations (this entity is a supertype of others)
    if (subSuper.supertypeDecl() != null) {
      ExpressParser.SupertypeDeclContext superDecl = subSuper.supertypeDecl();
      entity.IsAbstract = superDecl.ABSTRACT() != null;
      java.util.List<ExpressParser.SupertypeFactorContext> factors =
          superDecl.supertypeExpr().supertypeFactor();
      for (ExpressParser.SupertypeFactorContext factor : factors) {
        if (factor.entityRef() != null) {
          String subName = factor.entityRef().SimpleId().getText();
          Entity sub =
              (Entity)
                  TypeData.getOrDefault(
                      subName, new Entity(subName, GetSchema(context), generator));
          TypeData.putIfAbsent(subName, sub);
          entity.Subs.add(sub);
        } else if (factor.choice() != null) {
          for (ExpressParser.SupertypeExprContext superRef : factor.choice().supertypeExpr()) {
            if (superRef.supertypeFactor(0).entityRef() != null) {
              String subName = superRef.supertypeFactor(0).entityRef().SimpleId().getText();
              Entity sub =
                  (Entity)
                      TypeData.getOrDefault(
                          subName, new Entity(subName, GetSchema(context), generator));
              TypeData.putIfAbsent(subName, sub);
              entity.Subs.add(sub);
            }
          }
        }
      }
    }

    // SUBTYPE clause (this entity inherits from listed parents)
    if (subSuper.subtypeDecl() != null) {
      for (ExpressParser.EntityRefContext parentRef : subSuper.subtypeDecl().entityRef()) {
        String parentName = parentRef.SimpleId().getText();
        Entity parent =
            (Entity)
                TypeData.getOrDefault(
                    parentName, new Entity(parentName, GetSchema(context), generator));
        TypeData.putIfAbsent(parentName, parent);
        entity.Supers.add(parent);
      }
    }

    if (context.entityBody().attributes() != null) {
      ExpressParser.AttributesContext attrs = context.entityBody().attributes();
      for (ExpressParser.ExplicitClauseContext expl : attrs.explicitClause()) {
        if (expl.explDef() != null) {
          boolean optional = expl.explDef().OPTIONAL() != null;
          for (ExpressParser.AttrDefContext attrDef : expl.explDef().attrDef()) {
            RefInt rank = new RefInt(0);
            RefBoolean isCollection = new RefBoolean(false);
            RefBoolean isGeneric = new RefBoolean(false);
            String name = "";
            if (attrDef.SimpleId() != null) name = attrDef.SimpleId().getText();
            else if (attrDef.Path() != null) name = attrDef.Path().getText();
            String type =
                ParseCollectionTypeSel(
                    expl.explDef().collectionTypeSel(), rank, isCollection, isGeneric);
            AttributeData ad =
                new AttributeData(
                    generator,
                    name,
                    type,
                    rank.value,
                    isCollection.value,
                    isGeneric.value,
                    false,
                    optional,
                    false);
            entity.Attributes.add(ad);
            if (ad.getType() == null) throw new RuntimeException("Attribute type null: " + ad.Name);
          }
        } else if (expl.explRedef() != null) {
          RefInt rank = new RefInt(0);
          RefBoolean isCollection = new RefBoolean(false);
          RefBoolean isGeneric = new RefBoolean(false);
          String name = "";
          ExpressParser.AttrRefContext attrRef = expl.explRedef().attrRef();
          if (attrRef.SimpleId() != null) name = attrRef.SimpleId().getText();
          else if (attrRef.Path() != null) name = attrRef.Path().getText();
          boolean optional = expl.explRedef().OPTIONAL() != null;
          String type =
              ParseCollectionTypeSel(
                  expl.explRedef().collectionTypeSel(), rank, isCollection, isGeneric);
          AttributeData ad =
              new AttributeData(
                  generator,
                  name,
                  type,
                  rank.value,
                  isCollection.value,
                  isGeneric.value,
                  false,
                  optional,
                  false);
          entity.Attributes.add(ad);
          if (ad.getType() == null) throw new RuntimeException("Attribute type null: " + ad.Name);
        }
      }

      // DERIVE
      for (ExpressParser.DeriveClauseContext der : attrs.deriveClause()) {
        for (ExpressParser.DerivedAttrContext derAttr : der.derivedAttr()) {
          String name = "";
          RefInt rank = new RefInt(0);
          RefBoolean isCollection = new RefBoolean(false);
          RefBoolean isGeneric = new RefBoolean(false);
          if (derAttr.deriveDef() != null) {
            if (derAttr.deriveDef().attrDef().SimpleId() != null)
              name = derAttr.deriveDef().attrDef().SimpleId().getText();
            else if (derAttr.deriveDef().attrDef().Path() != null)
              name = derAttr.deriveDef().attrDef().Path().getText();
            String type =
                ParseCollectionTypeSel(
                    derAttr.deriveDef().collectionTypeSel(), rank, isCollection, isGeneric);
            AttributeData ad =
                new AttributeData(
                    generator,
                    name,
                    type,
                    rank.value,
                    isCollection.value,
                    isGeneric.value,
                    true,
                    false,
                    false);
            entity.Attributes.add(ad);
          } else if (derAttr.derivedRedef() != null) {
            if (derAttr.derivedRedef().attrRef().SimpleId() != null)
              name = derAttr.derivedRedef().attrRef().SimpleId().getText();
            else if (derAttr.derivedRedef().attrRef().Path() != null)
              name = derAttr.derivedRedef().attrRef().Path().getText();
            String type =
                ParseCollectionTypeSel(
                    derAttr.derivedRedef().collectionTypeSel(), rank, isCollection, isGeneric);
            AttributeData ad =
                new AttributeData(
                    generator,
                    name,
                    type,
                    rank.value,
                    isCollection.value,
                    isGeneric.value,
                    true,
                    false,
                    false);
            entity.Attributes.add(ad);
          }
        }
      }

      // INVERSE
      for (ExpressParser.InverseClauseContext inv : attrs.inverseClause()) {
        for (ExpressParser.InverseAttrContext invAttr : inv.inverseAttr()) {
          String name = "";
          RefInt rank = new RefInt(0);
          RefBoolean isCollection = new RefBoolean(false);
          boolean optional = false;
          boolean inverse = true;
          if (invAttr.inverseDef() != null) {
            if (invAttr.inverseDef().attrDef().SimpleId() != null)
              name = invAttr.inverseDef().attrDef().SimpleId().getText();
            else if (invAttr.inverseDef().attrDef().Path() != null)
              name = invAttr.inverseDef().attrDef().Path().getText();
            String type = ParseInverseType(invAttr.inverseDef().inverseType(), isCollection, rank);
            AttributeData ad =
                new AttributeData(
                    generator,
                    name,
                    type,
                    rank.value,
                    isCollection.value,
                    false,
                    false,
                    optional,
                    inverse);
            entity.Attributes.add(ad);
            InverseAttr inverseType =
                new InverseAttr(entity.Name, name, type, invAttr.inverseDef().attrRef().getText());
            InverseAttrData.computeIfAbsent(inverseType.inverseType, k -> new ArrayList<>())
                .add(inverseType);
          } else if (invAttr.inverseRedef() != null) {
            if (invAttr.inverseRedef().attrRef(0).SimpleId() != null)
              name = invAttr.inverseRedef().attrRef(0).SimpleId().getText();
            else if (invAttr.inverseRedef().attrRef(0).Path() != null)
              name = invAttr.inverseRedef().attrRef(0).Path().getText();
            String type =
                ParseInverseType(invAttr.inverseRedef().inverseType(), isCollection, rank);
            AttributeData ad =
                new AttributeData(
                    generator,
                    name,
                    type,
                    rank.value,
                    isCollection.value,
                    false,
                    false,
                    optional,
                    inverse);
            entity.Attributes.add(ad);
            InverseAttr inverseType =
                new InverseAttr(
                    entity.Name, name, type, invAttr.inverseRedef().attrRef(1).getText());
            InverseAttrData.computeIfAbsent(inverseType.inverseType, k -> new ArrayList<>())
                .add(inverseType);
          }
        }
      }
    }

    for (AttributeData a : entity.Attributes) {
      if (a.IsCollection && a.Rank == 0)
        throw new RuntimeException("Attribute with IsCollection true but rank 0");
      if (a.IsInverse && a.IsOptional)
        throw new RuntimeException("Attribute inverse cannot be optional");
    }
  }

  // FUNCTION
  @Override
  public void enterFuncHead(FuncHeadContext context) {
    String fName = context.funcDef().SimpleId().getText();
    RefBoolean fCollection = new RefBoolean(false);
    RefInt fRank = new RefInt(0);
    RefBoolean fGeneric = new RefBoolean(false);
    String fType = "";
    if (context.returnTypeChoice().allTypeSel() != null)
      fType = ParseAllTypeSel(context.returnTypeChoice().allTypeSel(), fCollection, fGeneric);
    else if (context.returnTypeChoice().collectionType() != null)
      fType =
          ParseCollectionType(
              context.returnTypeChoice().collectionType(), fRank, fCollection, fGeneric);

    List<ParameterData> parameters = new ArrayList<>();
    for (ExpressParser.FormalParamsContext formalParam : context.formalParams()) {
      for (ExpressParser.FormalParamContext p : formalParam.formalParam()) {
        RefBoolean pCollection = new RefBoolean(false);
        RefBoolean pGeneric = new RefBoolean(false);
        RefInt pRank = new RefInt(0);
        String pType = "";
        if (p.returnTypeChoice().allTypeSel() != null)
          pType = ParseAllTypeSel(p.returnTypeChoice().allTypeSel(), pCollection, pGeneric);
        else if (p.returnTypeChoice().collectionType() != null)
          pType =
              ParseCollectionType(
                  p.returnTypeChoice().collectionType(), pRank, pCollection, pGeneric);
        for (ExpressParser.ParamDefContext def : p.paramDef()) {
          String pName = def.SimpleId().getText();
          parameters.add(
              new ParameterData(
                  generator, pName, pCollection.value, pRank.value, pGeneric.value, pType));
        }
      }
    }

    TypeReference returnType =
        new TypeReference(generator, fType, fCollection.value, fRank.value, fGeneric.value);
    FunctionData fd = new FunctionData(fName, returnType, parameters);
    FunctionData.put(fName, fd);
  }

  private String ParseInverseType(
      ExpressParser.InverseTypeContext context, RefBoolean isCollection, RefInt rank) {
    if (context.SET() != null || context.BAG() != null) {
      isCollection.value = true;
      rank.value++;
    }
    return context.entityRef().SimpleId().getText();
  }

  private String ParseAllTypeSel(
      ExpressParser.AllTypeSelContext context, RefBoolean isCollection, RefBoolean isGeneric) {
    if (context.simpleType() != null) return ParseSimpleType(context.simpleType());
    if (context.namedType() != null) {
      if (context.namedType().typeRef() != null)
        return context.namedType().typeRef().SimpleId().getText();
      if (context.namedType().entityRef() != null)
        return context.namedType().entityRef().SimpleId().getText();
    } else if (context.pseudoType() != null) {
      if (context.pseudoType().genericType() != null) {
        isGeneric.value = true;
        return context.pseudoType().genericType().typeLabel().SimpleId().getText();
      }
    } else if (context.aggregateType() != null) {
      throw new UnsupportedOperationException();
    } else if (context.conformantType() != null) {
      return ParseConformantType(context.conformantType(), isCollection, isGeneric);
    }
    throw new RuntimeException("Unable to parse allTypeSel: " + context.getText());
  }

  private String ParseConformantType(
      ExpressParser.ConformantTypeContext context, RefBoolean isCollection, RefBoolean isGeneric) {
    if (context.conformantArray() != null)
      return ParseAllTypeSel(context.conformantArray().allTypeSel(), isCollection, isGeneric);
    if (context.conformantBag() != null)
      return ParseAllTypeSel(context.conformantBag().allTypeSel(), isCollection, isGeneric);
    if (context.conformantList() != null)
      return ParseAllTypeSel(context.conformantList().allTypeSel(), isCollection, isGeneric);
    if (context.conformantSet() != null)
      return ParseAllTypeSel(context.conformantSet().allTypeSel(), isCollection, isGeneric);
    throw new RuntimeException("Unable to parse conformant type: " + context.getText());
  }

  private String ParseSimpleType(ExpressParser.SimpleTypeContext context) {
    return generator.ParseSimpleType(context);
  }

  private String ParseNamedType(ExpressParser.NamedTypeContext context) {
    if (context.typeRef() != null) return context.typeRef().SimpleId().getText();
    if (context.entityRef() != null) return context.entityRef().SimpleId().getText();
    return null;
  }

  private String ParseCollectionType(
      ExpressParser.CollectionTypeContext context,
      RefInt rank,
      RefBoolean isCollection,
      RefBoolean isGeneric) {
    rank.value++;
    isCollection.value = true;
    if (context.arrayType() != null)
      return ParseCollectionTypeSel(
          context.arrayType().collectionTypeSel(), rank, isCollection, isGeneric);
    if (context.listType() != null)
      return ParseCollectionTypeSel(
          context.listType().collectionTypeSel(), rank, isCollection, isGeneric);
    if (context.setType() != null)
      return ParseCollectionTypeSel(
          context.setType().collectionTypeSel(), rank, isCollection, isGeneric);
    if (context.bagType() != null)
      return ParseCollectionTypeSel(
          context.bagType().collectionTypeSel(), rank, isCollection, isGeneric);
    throw new RuntimeException("Unable to parse collection type");
  }

  private String ParseCollectionTypeSel(
      ExpressParser.CollectionTypeSelContext context,
      RefInt rank,
      RefBoolean isCollection,
      RefBoolean isGeneric) {
    if (context.collectionType() != null)
      return ParseCollectionType(context.collectionType(), rank, isCollection, isGeneric);
    if (context.simpleType() != null) return ParseSimpleType(context.simpleType());
    if (context.namedType() != null) return ParseNamedType(context.namedType());
    if (context.genericType() != null) {
      isGeneric.value = true;
      return "T";
    }
    throw new RuntimeException("Unable to parse collection type selection: " + context.getText());
  }

  private static RefBoolean ref(boolean v) {
    return new RefBoolean(v);
  }

  private static RefInt ref(int v) {
    return new RefInt(v);
  }

  private static class RefBoolean {
    boolean value;

    RefBoolean(boolean v) {
      value = v;
    }
  }

  private static class RefInt {
    int value;

    RefInt(int v) {
      value = v;
    }
  }
}
