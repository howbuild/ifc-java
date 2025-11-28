package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBuildingSystem
 * SUBTYPE OF (IfcSystem);
 * PredefinedType : OPTIONAL IfcBuildingSystemTypeEnum;
 * LongName : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcbuildingsystem.htm">IfcBuildingSystem</a>
 */
public class IfcBuildingSystem extends IfcSystem {
    protected IfcBuildingSystemTypeEnum predefinedType;
    protected IfcLabel longName;

    protected IfcBuildingSystem() { initCollections(); }
    /**
     * Constructs IfcBuildingSystem with all required attributes.
     */
    public IfcBuildingSystem(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcBuildingSystem with required and optional attributes.
     */
    public IfcBuildingSystem(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcBuildingSystemTypeEnum predefinedType,IfcLabel longName) {
        super(globalId,ownerHistory,name,description,objectType);
        this.predefinedType = predefinedType;
        this.longName = longName;
    }
    private void initCollections() {
    }
    public IfcBuildingSystemTypeEnum getPredefinedType() { return this.predefinedType; }
    public void setPredefinedType(IfcBuildingSystemTypeEnum value) { this.predefinedType = value; } // optional
    public IfcLabel getLongName() { return this.longName; }
    public void setLongName(IfcLabel value) { this.longName = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
		parameters.add(StepUtils.toStepValue(predefinedType));
		parameters.add(longName != null ? StepUtils.toStepValue(longName) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}