package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBoundaryCondition
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBoundaryEdgeCondition
 * ,IfcBoundaryFaceCondition
 * ,IfcBoundaryNodeCondition));
 * Name : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcboundarynodecondition.htm">IfcBoundaryNodeCondition</a>
 */
public class IfcBoundaryNodeCondition extends IfcBoundaryCondition {
    protected IfcTranslationalStiffnessSelect translationalStiffnessX;
    protected IfcTranslationalStiffnessSelect translationalStiffnessY;
    protected IfcTranslationalStiffnessSelect translationalStiffnessZ;
    protected IfcRotationalStiffnessSelect rotationalStiffnessX;
    protected IfcRotationalStiffnessSelect rotationalStiffnessY;
    protected IfcRotationalStiffnessSelect rotationalStiffnessZ;


    /**
     * Constructs IfcBoundaryNodeCondition with all required attributes.
     */
    public IfcBoundaryNodeCondition() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcBoundaryNodeCondition with required and optional attributes.
     */
    public IfcBoundaryNodeCondition(IfcLabel name,IfcTranslationalStiffnessSelect translationalStiffnessX,IfcTranslationalStiffnessSelect translationalStiffnessY,IfcTranslationalStiffnessSelect translationalStiffnessZ,IfcRotationalStiffnessSelect rotationalStiffnessX,IfcRotationalStiffnessSelect rotationalStiffnessY,IfcRotationalStiffnessSelect rotationalStiffnessZ) {
        super(name);
        this.translationalStiffnessX = translationalStiffnessX;
        this.translationalStiffnessY = translationalStiffnessY;
        this.translationalStiffnessZ = translationalStiffnessZ;
        this.rotationalStiffnessX = rotationalStiffnessX;
        this.rotationalStiffnessY = rotationalStiffnessY;
        this.rotationalStiffnessZ = rotationalStiffnessZ;
    }
    private void initCollections() {
    }
    public IfcTranslationalStiffnessSelect getTranslationalStiffnessX() { return this.translationalStiffnessX; }
    public void setTranslationalStiffnessX(IfcTranslationalStiffnessSelect value) { this.translationalStiffnessX = value; } // optional
    public IfcTranslationalStiffnessSelect getTranslationalStiffnessY() { return this.translationalStiffnessY; }
    public void setTranslationalStiffnessY(IfcTranslationalStiffnessSelect value) { this.translationalStiffnessY = value; } // optional
    public IfcTranslationalStiffnessSelect getTranslationalStiffnessZ() { return this.translationalStiffnessZ; }
    public void setTranslationalStiffnessZ(IfcTranslationalStiffnessSelect value) { this.translationalStiffnessZ = value; } // optional
    public IfcRotationalStiffnessSelect getRotationalStiffnessX() { return this.rotationalStiffnessX; }
    public void setRotationalStiffnessX(IfcRotationalStiffnessSelect value) { this.rotationalStiffnessX = value; } // optional
    public IfcRotationalStiffnessSelect getRotationalStiffnessY() { return this.rotationalStiffnessY; }
    public void setRotationalStiffnessY(IfcRotationalStiffnessSelect value) { this.rotationalStiffnessY = value; } // optional
    public IfcRotationalStiffnessSelect getRotationalStiffnessZ() { return this.rotationalStiffnessZ; }
    public void setRotationalStiffnessZ(IfcRotationalStiffnessSelect value) { this.rotationalStiffnessZ = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(translationalStiffnessX != null ? StepUtils.toStepValue(translationalStiffnessX) : "$");
		parameters.add(translationalStiffnessY != null ? StepUtils.toStepValue(translationalStiffnessY) : "$");
		parameters.add(translationalStiffnessZ != null ? StepUtils.toStepValue(translationalStiffnessZ) : "$");
		parameters.add(rotationalStiffnessX != null ? StepUtils.toStepValue(rotationalStiffnessX) : "$");
		parameters.add(rotationalStiffnessY != null ? StepUtils.toStepValue(rotationalStiffnessY) : "$");
		parameters.add(rotationalStiffnessZ != null ? StepUtils.toStepValue(rotationalStiffnessZ) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}