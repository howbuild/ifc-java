package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcProduct
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcAnnotation
 * ,IfcElement
 * ,IfcGrid
 * ,IfcPort
 * ,IfcProxy
 * ,IfcSpatialElement
 * ,IfcStructuralActivity
 * ,IfcStructuralItem))
 * SUBTYPE OF (IfcObject);
 * ObjectPlacement : OPTIONAL IfcObjectPlacement;
 * Representation : OPTIONAL IfcProductRepresentation;
 * INVERSE
 * ReferencedBy : SET [0:?] OF IfcRelAssignsToProduct FOR RelatingProduct;
 * WHERE
 * PlacementForShapeRepresentation : (EXISTS(Representation) AND EXISTS(ObjectPlacement))
 * OR (EXISTS(Representation) AND
 * (SIZEOF(QUERY(temp <* Representation.Representations | 'IFC4.IFCSHAPEREPRESENTATION' IN TYPEOF(temp))) = 0))
 * OR (NOT(EXISTS(Representation)));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcproxy.htm">IfcProxy</a>
 */
public class IfcProxy extends IfcProduct {
    protected IfcObjectTypeEnum proxyType;
    protected IfcLabel tag;

    protected IfcProxy() { initCollections(); }
    /**
     * Constructs IfcProxy with all required attributes.
     */
    public IfcProxy(IfcGloballyUniqueId globalId,IfcObjectTypeEnum proxyType) {

        super(globalId);
        this.proxyType = proxyType;
    }
    /**
     * Constructs IfcProxy with required and optional attributes.
     */
    public IfcProxy(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcObjectTypeEnum proxyType,IfcLabel tag) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation);
        this.proxyType = proxyType;
        this.tag = tag;
    }
    private void initCollections() {
    }
    public IfcObjectTypeEnum getProxyType() { return this.proxyType; }
    public void setProxyType(IfcObjectTypeEnum value) { this.proxyType = value; }
    public IfcLabel getTag() { return this.tag; }
    public void setTag(IfcLabel value) { this.tag = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(StepUtils.toStepValue(proxyType));
		parameters.add(tag != null ? StepUtils.toStepValue(tag) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}