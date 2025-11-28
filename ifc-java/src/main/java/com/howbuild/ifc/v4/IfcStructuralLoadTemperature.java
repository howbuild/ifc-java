package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralLoadStatic
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcStructuralLoadLinearForce
 * ,IfcStructuralLoadPlanarForce
 * ,IfcStructuralLoadSingleDisplacement
 * ,IfcStructuralLoadSingleForce
 * ,IfcStructuralLoadTemperature))
 * SUBTYPE OF (IfcStructuralLoadOrResult);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralloadtemperature.htm">IfcStructuralLoadTemperature</a>
 */
public class IfcStructuralLoadTemperature extends IfcStructuralLoadStatic {
    protected IfcThermodynamicTemperatureMeasure deltaTConstant;
    protected IfcThermodynamicTemperatureMeasure deltaTY;
    protected IfcThermodynamicTemperatureMeasure deltaTZ;


    /**
     * Constructs IfcStructuralLoadTemperature with all required attributes.
     */
    public IfcStructuralLoadTemperature() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcStructuralLoadTemperature with required and optional attributes.
     */
    public IfcStructuralLoadTemperature(IfcLabel name,IfcThermodynamicTemperatureMeasure deltaTConstant,IfcThermodynamicTemperatureMeasure deltaTY,IfcThermodynamicTemperatureMeasure deltaTZ) {
        super(name);
        this.deltaTConstant = deltaTConstant;
        this.deltaTY = deltaTY;
        this.deltaTZ = deltaTZ;
    }
    private void initCollections() {
    }
    public IfcThermodynamicTemperatureMeasure getDeltaTConstant() { return this.deltaTConstant; }
    public void setDeltaTConstant(IfcThermodynamicTemperatureMeasure value) { this.deltaTConstant = value; } // optional
    public IfcThermodynamicTemperatureMeasure getDeltaTY() { return this.deltaTY; }
    public void setDeltaTY(IfcThermodynamicTemperatureMeasure value) { this.deltaTY = value; } // optional
    public IfcThermodynamicTemperatureMeasure getDeltaTZ() { return this.deltaTZ; }
    public void setDeltaTZ(IfcThermodynamicTemperatureMeasure value) { this.deltaTZ = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(deltaTConstant != null ? StepUtils.toStepValue(deltaTConstant) : "$");
		parameters.add(deltaTY != null ? StepUtils.toStepValue(deltaTY) : "$");
		parameters.add(deltaTZ != null ? StepUtils.toStepValue(deltaTZ) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}