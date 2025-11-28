package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSystem
 * SUPERTYPE OF (ONEOF
 * (IfcBuildingSystem
 * ,IfcDistributionSystem
 * ,IfcStructuralAnalysisModel
 * ,IfcZone))
 * SUBTYPE OF (IfcGroup);
 * INVERSE
 * ServicesBuildings : SET [0:1] OF IfcRelServicesBuildings FOR RelatingSystem;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifczone.htm">IfcZone</a>
 */
public class IfcZone extends IfcSystem {
    protected IfcLabel longName;

    protected IfcZone() { initCollections(); }
    /**
     * Constructs IfcZone with all required attributes.
     */
    public IfcZone(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcZone with required and optional attributes.
     */
    public IfcZone(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcLabel longName) {
        super(globalId,ownerHistory,name,description,objectType);
        this.longName = longName;
    }
    private void initCollections() {
    }
    public IfcLabel getLongName() { return this.longName; }
    public void setLongName(IfcLabel value) { this.longName = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(longName != null ? StepUtils.toStepValue(longName) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}