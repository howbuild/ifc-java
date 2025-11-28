package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcExternalSpatialElement
 * SUBTYPE OF (IfcExternalSpatialStructureElement);
 * PredefinedType : OPTIONAL IfcExternalSpatialElementTypeEnum;
 * INVERSE
 * BoundedBy : SET [0:?] OF IfcRelSpaceBoundary FOR RelatingSpace;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcexternalspatialelement.htm">IfcExternalSpatialElement</a>
 */
public class IfcExternalSpatialElement extends IfcExternalSpatialStructureElement implements IfcSpaceBoundarySelect {
    protected IfcExternalSpatialElementTypeEnum predefinedType;
    protected Collection<IfcRelSpaceBoundary> boundedBy;

    protected IfcExternalSpatialElement() { initCollections(); }
    /**
     * Constructs IfcExternalSpatialElement with all required attributes.
     */
    public IfcExternalSpatialElement(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.boundedBy = new ArrayList<>();
    }
    /**
     * Constructs IfcExternalSpatialElement with required and optional attributes.
     */
    public IfcExternalSpatialElement(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcLabel longName,IfcExternalSpatialElementTypeEnum predefinedType) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,longName);
        this.boundedBy = new ArrayList<>();
        this.predefinedType = predefinedType;
    }
    private void initCollections() {
        this.boundedBy = new ArrayList<>();
    }
    public IfcExternalSpatialElementTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcExternalSpatialElementTypeEnum value) { this.predefinedType = value; } // optional
    public Collection<IfcRelSpaceBoundary> getBoundedBy() { return this.boundedBy; }
    public void setBoundedBy(Collection<IfcRelSpaceBoundary> value) { this.boundedBy = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(objectPlacement != null ? StepUtils.toStepValue(objectPlacement) : "$");
		parameters.add(representation != null ? StepUtils.toStepValue(representation) : "$");
		parameters.add(longName != null ? StepUtils.toStepValue(longName) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}