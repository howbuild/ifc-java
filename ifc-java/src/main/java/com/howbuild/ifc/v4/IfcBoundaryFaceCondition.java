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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcboundaryfacecondition.htm">IfcBoundaryFaceCondition</a>
 */
public class IfcBoundaryFaceCondition extends IfcBoundaryCondition {
    protected IfcModulusOfSubgradeReactionSelect translationalStiffnessByAreaX;
    protected IfcModulusOfSubgradeReactionSelect translationalStiffnessByAreaY;
    protected IfcModulusOfSubgradeReactionSelect translationalStiffnessByAreaZ;


    /**
     * Constructs IfcBoundaryFaceCondition with all required attributes.
     */
    public IfcBoundaryFaceCondition() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcBoundaryFaceCondition with required and optional attributes.
     */
    public IfcBoundaryFaceCondition(IfcLabel name,IfcModulusOfSubgradeReactionSelect translationalStiffnessByAreaX,IfcModulusOfSubgradeReactionSelect translationalStiffnessByAreaY,IfcModulusOfSubgradeReactionSelect translationalStiffnessByAreaZ) {
        super(name);
        this.translationalStiffnessByAreaX = translationalStiffnessByAreaX;
        this.translationalStiffnessByAreaY = translationalStiffnessByAreaY;
        this.translationalStiffnessByAreaZ = translationalStiffnessByAreaZ;
    }
    private void initCollections() {
    }
    public IfcModulusOfSubgradeReactionSelect getTranslationalStiffnessByAreaX() { return this.translationalStiffnessByAreaX; }
    public void setTranslationalStiffnessByAreaX(IfcModulusOfSubgradeReactionSelect value) { this.translationalStiffnessByAreaX = value; } // optional
    public IfcModulusOfSubgradeReactionSelect getTranslationalStiffnessByAreaY() { return this.translationalStiffnessByAreaY; }
    public void setTranslationalStiffnessByAreaY(IfcModulusOfSubgradeReactionSelect value) { this.translationalStiffnessByAreaY = value; } // optional
    public IfcModulusOfSubgradeReactionSelect getTranslationalStiffnessByAreaZ() { return this.translationalStiffnessByAreaZ; }
    public void setTranslationalStiffnessByAreaZ(IfcModulusOfSubgradeReactionSelect value) { this.translationalStiffnessByAreaZ = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(translationalStiffnessByAreaX != null ? StepUtils.toStepValue(translationalStiffnessByAreaX) : "$");
		parameters.add(translationalStiffnessByAreaY != null ? StepUtils.toStepValue(translationalStiffnessByAreaY) : "$");
		parameters.add(translationalStiffnessByAreaZ != null ? StepUtils.toStepValue(translationalStiffnessByAreaZ) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}