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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcboundaryedgecondition.htm">IfcBoundaryEdgeCondition</a>
 */
public class IfcBoundaryEdgeCondition extends IfcBoundaryCondition {
    protected IfcModulusOfTranslationalSubgradeReactionSelect translationalStiffnessByLengthX;
    protected IfcModulusOfTranslationalSubgradeReactionSelect translationalStiffnessByLengthY;
    protected IfcModulusOfTranslationalSubgradeReactionSelect translationalStiffnessByLengthZ;
    protected IfcModulusOfRotationalSubgradeReactionSelect rotationalStiffnessByLengthX;
    protected IfcModulusOfRotationalSubgradeReactionSelect rotationalStiffnessByLengthY;
    protected IfcModulusOfRotationalSubgradeReactionSelect rotationalStiffnessByLengthZ;


    /**
     * Constructs IfcBoundaryEdgeCondition with all required attributes.
     */
    public IfcBoundaryEdgeCondition() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcBoundaryEdgeCondition with required and optional attributes.
     */
    public IfcBoundaryEdgeCondition(IfcLabel name,IfcModulusOfTranslationalSubgradeReactionSelect translationalStiffnessByLengthX,IfcModulusOfTranslationalSubgradeReactionSelect translationalStiffnessByLengthY,IfcModulusOfTranslationalSubgradeReactionSelect translationalStiffnessByLengthZ,IfcModulusOfRotationalSubgradeReactionSelect rotationalStiffnessByLengthX,IfcModulusOfRotationalSubgradeReactionSelect rotationalStiffnessByLengthY,IfcModulusOfRotationalSubgradeReactionSelect rotationalStiffnessByLengthZ) {
        super(name);
        this.translationalStiffnessByLengthX = translationalStiffnessByLengthX;
        this.translationalStiffnessByLengthY = translationalStiffnessByLengthY;
        this.translationalStiffnessByLengthZ = translationalStiffnessByLengthZ;
        this.rotationalStiffnessByLengthX = rotationalStiffnessByLengthX;
        this.rotationalStiffnessByLengthY = rotationalStiffnessByLengthY;
        this.rotationalStiffnessByLengthZ = rotationalStiffnessByLengthZ;
    }
    private void initCollections() {
    }
    public IfcModulusOfTranslationalSubgradeReactionSelect getTranslationalStiffnessByLengthX() { return this.translationalStiffnessByLengthX; }
    public void setTranslationalStiffnessByLengthX(IfcModulusOfTranslationalSubgradeReactionSelect value) { this.translationalStiffnessByLengthX = value; } // optional
    public IfcModulusOfTranslationalSubgradeReactionSelect getTranslationalStiffnessByLengthY() { return this.translationalStiffnessByLengthY; }
    public void setTranslationalStiffnessByLengthY(IfcModulusOfTranslationalSubgradeReactionSelect value) { this.translationalStiffnessByLengthY = value; } // optional
    public IfcModulusOfTranslationalSubgradeReactionSelect getTranslationalStiffnessByLengthZ() { return this.translationalStiffnessByLengthZ; }
    public void setTranslationalStiffnessByLengthZ(IfcModulusOfTranslationalSubgradeReactionSelect value) { this.translationalStiffnessByLengthZ = value; } // optional
    public IfcModulusOfRotationalSubgradeReactionSelect getRotationalStiffnessByLengthX() { return this.rotationalStiffnessByLengthX; }
    public void setRotationalStiffnessByLengthX(IfcModulusOfRotationalSubgradeReactionSelect value) { this.rotationalStiffnessByLengthX = value; } // optional
    public IfcModulusOfRotationalSubgradeReactionSelect getRotationalStiffnessByLengthY() { return this.rotationalStiffnessByLengthY; }
    public void setRotationalStiffnessByLengthY(IfcModulusOfRotationalSubgradeReactionSelect value) { this.rotationalStiffnessByLengthY = value; } // optional
    public IfcModulusOfRotationalSubgradeReactionSelect getRotationalStiffnessByLengthZ() { return this.rotationalStiffnessByLengthZ; }
    public void setRotationalStiffnessByLengthZ(IfcModulusOfRotationalSubgradeReactionSelect value) { this.rotationalStiffnessByLengthZ = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(translationalStiffnessByLengthX != null ? StepUtils.toStepValue(translationalStiffnessByLengthX) : "$");
		parameters.add(translationalStiffnessByLengthY != null ? StepUtils.toStepValue(translationalStiffnessByLengthY) : "$");
		parameters.add(translationalStiffnessByLengthZ != null ? StepUtils.toStepValue(translationalStiffnessByLengthZ) : "$");
		parameters.add(rotationalStiffnessByLengthX != null ? StepUtils.toStepValue(rotationalStiffnessByLengthX) : "$");
		parameters.add(rotationalStiffnessByLengthY != null ? StepUtils.toStepValue(rotationalStiffnessByLengthY) : "$");
		parameters.add(rotationalStiffnessByLengthZ != null ? StepUtils.toStepValue(rotationalStiffnessByLengthZ) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}