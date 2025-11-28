package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralLoadLinearForce
 * SUBTYPE OF (IfcStructuralLoadStatic);
 * LinearForceX : OPTIONAL IfcLinearForceMeasure;
 * LinearForceY : OPTIONAL IfcLinearForceMeasure;
 * LinearForceZ : OPTIONAL IfcLinearForceMeasure;
 * LinearMomentX : OPTIONAL IfcLinearMomentMeasure;
 * LinearMomentY : OPTIONAL IfcLinearMomentMeasure;
 * LinearMomentZ : OPTIONAL IfcLinearMomentMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralloadlinearforce.htm">IfcStructuralLoadLinearForce</a>
 */
public class IfcStructuralLoadLinearForce extends IfcStructuralLoadStatic {
    protected IfcLinearForceMeasure linearForceX;
    protected IfcLinearForceMeasure linearForceY;
    protected IfcLinearForceMeasure linearForceZ;
    protected IfcLinearMomentMeasure linearMomentX;
    protected IfcLinearMomentMeasure linearMomentY;
    protected IfcLinearMomentMeasure linearMomentZ;


    /**
     * Constructs IfcStructuralLoadLinearForce with all required attributes.
     */
    public IfcStructuralLoadLinearForce() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcStructuralLoadLinearForce with required and optional attributes.
     */
    public IfcStructuralLoadLinearForce(IfcLabel name,IfcLinearForceMeasure linearForceX,IfcLinearForceMeasure linearForceY,IfcLinearForceMeasure linearForceZ,IfcLinearMomentMeasure linearMomentX,IfcLinearMomentMeasure linearMomentY,IfcLinearMomentMeasure linearMomentZ) {
        super(name);
        this.linearForceX = linearForceX;
        this.linearForceY = linearForceY;
        this.linearForceZ = linearForceZ;
        this.linearMomentX = linearMomentX;
        this.linearMomentY = linearMomentY;
        this.linearMomentZ = linearMomentZ;
    }
    private void initCollections() {
    }
    public IfcLinearForceMeasure getLinearForceX() { return this.linearForceX; }
    public void setLinearForceX(IfcLinearForceMeasure value) { this.linearForceX = value; } // optional
    public IfcLinearForceMeasure getLinearForceY() { return this.linearForceY; }
    public void setLinearForceY(IfcLinearForceMeasure value) { this.linearForceY = value; } // optional
    public IfcLinearForceMeasure getLinearForceZ() { return this.linearForceZ; }
    public void setLinearForceZ(IfcLinearForceMeasure value) { this.linearForceZ = value; } // optional
    public IfcLinearMomentMeasure getLinearMomentX() { return this.linearMomentX; }
    public void setLinearMomentX(IfcLinearMomentMeasure value) { this.linearMomentX = value; } // optional
    public IfcLinearMomentMeasure getLinearMomentY() { return this.linearMomentY; }
    public void setLinearMomentY(IfcLinearMomentMeasure value) { this.linearMomentY = value; } // optional
    public IfcLinearMomentMeasure getLinearMomentZ() { return this.linearMomentZ; }
    public void setLinearMomentZ(IfcLinearMomentMeasure value) { this.linearMomentZ = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(linearForceX != null ? StepUtils.toStepValue(linearForceX) : "$");
		parameters.add(linearForceY != null ? StepUtils.toStepValue(linearForceY) : "$");
		parameters.add(linearForceZ != null ? StepUtils.toStepValue(linearForceZ) : "$");
		parameters.add(linearMomentX != null ? StepUtils.toStepValue(linearMomentX) : "$");
		parameters.add(linearMomentY != null ? StepUtils.toStepValue(linearMomentY) : "$");
		parameters.add(linearMomentZ != null ? StepUtils.toStepValue(linearMomentZ) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}