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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsystem.htm">IfcSystem</a>
 */
public class IfcSystem extends IfcGroup {
    protected Collection<IfcRelServicesBuildings> servicesBuildings;

    protected IfcSystem() { initCollections(); }
    /**
     * Constructs IfcSystem with all required attributes.
     */
    public IfcSystem(IfcGloballyUniqueId globalId) {

        super(globalId);
        this.servicesBuildings = new ArrayList<>();
    }
    /**
     * Constructs IfcSystem with required and optional attributes.
     */
    public IfcSystem(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType) {
        super(globalId,ownerHistory,name,description,objectType);
        this.servicesBuildings = new ArrayList<>();
    }
    private void initCollections() {
        this.servicesBuildings = new ArrayList<>();
    }
    public Collection<IfcRelServicesBuildings> getServicesBuildings() { return this.servicesBuildings; }
    public void setServicesBuildings(Collection<IfcRelServicesBuildings> value) { this.servicesBuildings = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(objectType != null ? StepUtils.toStepValue(objectType) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}