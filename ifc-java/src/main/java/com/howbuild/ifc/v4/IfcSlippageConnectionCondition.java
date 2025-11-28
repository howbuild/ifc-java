package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSlippageConnectionCondition
 * SUBTYPE OF (IfcStructuralConnectionCondition);
 * SlippageX : OPTIONAL IfcLengthMeasure;
 * SlippageY : OPTIONAL IfcLengthMeasure;
 * SlippageZ : OPTIONAL IfcLengthMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcslippageconnectioncondition.htm">IfcSlippageConnectionCondition</a>
 */
public class IfcSlippageConnectionCondition extends IfcStructuralConnectionCondition {
    protected IfcLengthMeasure slippageX;
    protected IfcLengthMeasure slippageY;
    protected IfcLengthMeasure slippageZ;


    /**
     * Constructs IfcSlippageConnectionCondition with all required attributes.
     */
    public IfcSlippageConnectionCondition() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcSlippageConnectionCondition with required and optional attributes.
     */
    public IfcSlippageConnectionCondition(IfcLabel name,IfcLengthMeasure slippageX,IfcLengthMeasure slippageY,IfcLengthMeasure slippageZ) {
        super(name);
        this.slippageX = slippageX;
        this.slippageY = slippageY;
        this.slippageZ = slippageZ;
    }
    private void initCollections() {
    }
    public IfcLengthMeasure getSlippageX() { return this.slippageX; }
    public void setSlippageX(IfcLengthMeasure value) { this.slippageX = value; } // optional
    public IfcLengthMeasure getSlippageY() { return this.slippageY; }
    public void setSlippageY(IfcLengthMeasure value) { this.slippageY = value; } // optional
    public IfcLengthMeasure getSlippageZ() { return this.slippageZ; }
    public void setSlippageZ(IfcLengthMeasure value) { this.slippageZ = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(slippageX != null ? StepUtils.toStepValue(slippageX) : "$");
		parameters.add(slippageY != null ? StepUtils.toStepValue(slippageY) : "$");
		parameters.add(slippageZ != null ? StepUtils.toStepValue(slippageZ) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}