package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelSpaceBoundary
 * SUPERTYPE OF (ONEOF
 * (IfcRelSpaceBoundary1stLevel))
 * SUBTYPE OF (IfcRelConnects);
 * RelatingSpace : IfcSpaceBoundarySelect;
 * RelatedBuildingElement : IfcElement;
 * ConnectionGeometry : OPTIONAL IfcConnectionGeometry;
 * PhysicalOrVirtualBoundary : IfcPhysicalOrVirtualEnum;
 * InternalOrExternalBoundary : IfcInternalOrExternalEnum;
 * WHERE
 * CorrectPhysOrVirt : ((PhysicalOrVirtualBoundary = IfcPhysicalOrVirtualEnum.Physical)
 * AND (NOT('IFC4.IFCVIRTUALELEMENT' IN TYPEOF(RelatedBuildingElement))))
 * OR
 * ((PhysicalOrVirtualBoundary = IfcPhysicalOrVirtualEnum.Virtual)
 * AND (('IFC4.IFCVIRTUALELEMENT' IN TYPEOF(RelatedBuildingElement))
 * OR   ('IFC4.IFCOPENINGELEMENT' IN TYPEOF(RelatedBuildingElement))))
 * OR
 * (PhysicalOrVirtualBoundary = IfcPhysicalOrVirtualEnum.NotDefined);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelspaceboundary1stlevel.htm">IfcRelSpaceBoundary1stLevel</a>
 */
public class IfcRelSpaceBoundary1stLevel extends IfcRelSpaceBoundary {
    protected IfcRelSpaceBoundary1stLevel parentBoundary;
    protected Collection<IfcRelSpaceBoundary1stLevel> innerBoundaries;

    protected IfcRelSpaceBoundary1stLevel() { initCollections(); }
    /**
     * Constructs IfcRelSpaceBoundary1stLevel with all required attributes.
     */
    public IfcRelSpaceBoundary1stLevel(IfcGloballyUniqueId globalId,IfcSpaceBoundarySelect relatingSpace,IfcElement relatedBuildingElement,IfcPhysicalOrVirtualEnum physicalOrVirtualBoundary,IfcInternalOrExternalEnum internalOrExternalBoundary) {

        super(globalId,relatingSpace,relatedBuildingElement,physicalOrVirtualBoundary,internalOrExternalBoundary);
        this.innerBoundaries = new ArrayList<>();
    }
    /**
     * Constructs IfcRelSpaceBoundary1stLevel with required and optional attributes.
     */
    public IfcRelSpaceBoundary1stLevel(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcSpaceBoundarySelect relatingSpace,IfcElement relatedBuildingElement,IfcConnectionGeometry connectionGeometry,IfcPhysicalOrVirtualEnum physicalOrVirtualBoundary,IfcInternalOrExternalEnum internalOrExternalBoundary,IfcRelSpaceBoundary1stLevel parentBoundary) {
        super(globalId,ownerHistory,name,description,relatingSpace,relatedBuildingElement,connectionGeometry,physicalOrVirtualBoundary,internalOrExternalBoundary);
        this.innerBoundaries = new ArrayList<>();
        this.parentBoundary = parentBoundary;
    }
    private void initCollections() {
        this.innerBoundaries = new ArrayList<>();
    }
    public IfcRelSpaceBoundary1stLevel getParentBoundary() { return this.parentBoundary; }
    public void setParentBoundary(IfcRelSpaceBoundary1stLevel value) { this.parentBoundary = value; } // optional
    public Collection<IfcRelSpaceBoundary1stLevel> getInnerBoundaries() { return this.innerBoundaries; }
    public void setInnerBoundaries(Collection<IfcRelSpaceBoundary1stLevel> value) { this.innerBoundaries = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(relatingSpace != null ? StepUtils.toStepValue(relatingSpace) : "$");
		parameters.add(relatedBuildingElement != null ? StepUtils.toStepValue(relatedBuildingElement) : "$");
		parameters.add(connectionGeometry != null ? StepUtils.toStepValue(connectionGeometry) : "$");
		parameters.add(StepUtils.toStepValue(physicalOrVirtualBoundary));
		parameters.add(StepUtils.toStepValue(internalOrExternalBoundary));
		parameters.add(parentBoundary != null ? StepUtils.toStepValue(parentBoundary) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelSpaceBoundary1stLevelRelationship(); }
    private void setIfcRelSpaceBoundary1stLevelRelationship() {
		if (this.parentBoundary != null) {
		    if (this.parentBoundary instanceof IfcRelSpaceBoundary1stLevel)
		        ((IfcRelSpaceBoundary1stLevel)this.parentBoundary).innerBoundaries.add(this);
		}
    }
}