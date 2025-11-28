package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelSpaceBoundary1stLevel
 * SUPERTYPE OF (ONEOF
 * (IfcRelSpaceBoundary2ndLevel))
 * SUBTYPE OF (IfcRelSpaceBoundary);
 * ParentBoundary : OPTIONAL IfcRelSpaceBoundary1stLevel;
 * INVERSE
 * InnerBoundaries : SET [0:?] OF IfcRelSpaceBoundary1stLevel FOR ParentBoundary;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelspaceboundary2ndlevel.htm">IfcRelSpaceBoundary2ndLevel</a>
 */
public class IfcRelSpaceBoundary2ndLevel extends IfcRelSpaceBoundary1stLevel {
    protected IfcRelSpaceBoundary2ndLevel correspondingBoundary;
    protected Collection<IfcRelSpaceBoundary2ndLevel> corresponds;

    protected IfcRelSpaceBoundary2ndLevel() { initCollections(); }
    /**
     * Constructs IfcRelSpaceBoundary2ndLevel with all required attributes.
     */
    public IfcRelSpaceBoundary2ndLevel(IfcGloballyUniqueId globalId,IfcSpaceBoundarySelect relatingSpace,IfcElement relatedBuildingElement,IfcPhysicalOrVirtualEnum physicalOrVirtualBoundary,IfcInternalOrExternalEnum internalOrExternalBoundary) {

        super(globalId,relatingSpace,relatedBuildingElement,physicalOrVirtualBoundary,internalOrExternalBoundary);
        this.corresponds = new ArrayList<>();
    }
    /**
     * Constructs IfcRelSpaceBoundary2ndLevel with required and optional attributes.
     */
    public IfcRelSpaceBoundary2ndLevel(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcSpaceBoundarySelect relatingSpace,IfcElement relatedBuildingElement,IfcConnectionGeometry connectionGeometry,IfcPhysicalOrVirtualEnum physicalOrVirtualBoundary,IfcInternalOrExternalEnum internalOrExternalBoundary,IfcRelSpaceBoundary1stLevel parentBoundary,IfcRelSpaceBoundary2ndLevel correspondingBoundary) {
        super(globalId,ownerHistory,name,description,relatingSpace,relatedBuildingElement,connectionGeometry,physicalOrVirtualBoundary,internalOrExternalBoundary,parentBoundary);
        this.corresponds = new ArrayList<>();
        this.correspondingBoundary = correspondingBoundary;
    }
    private void initCollections() {
        this.corresponds = new ArrayList<>();
    }
    public IfcRelSpaceBoundary2ndLevel getCorrespondingBoundary() { return this.correspondingBoundary; }
    public void setCorrespondingBoundary(IfcRelSpaceBoundary2ndLevel value) { this.correspondingBoundary = value; } // optional
    public Collection<IfcRelSpaceBoundary2ndLevel> getCorresponds() { return this.corresponds; }
    public void setCorresponds(Collection<IfcRelSpaceBoundary2ndLevel> value) { this.corresponds = value; } // inverse

    
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
		parameters.add(correspondingBoundary != null ? StepUtils.toStepValue(correspondingBoundary) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcRelSpaceBoundary2ndLevelRelationship(); }
    private void setIfcRelSpaceBoundary2ndLevelRelationship() {
		if (this.correspondingBoundary != null) {
		    if (this.correspondingBoundary instanceof IfcRelSpaceBoundary2ndLevel)
		        ((IfcRelSpaceBoundary2ndLevel)this.correspondingBoundary).corresponds.add(this);
		}
    }
}