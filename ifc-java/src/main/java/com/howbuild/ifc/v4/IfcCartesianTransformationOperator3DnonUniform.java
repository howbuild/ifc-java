package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCartesianTransformationOperator3D
 * SUPERTYPE OF (ONEOF
 * (IfcCartesianTransformationOperator3DnonUniform))
 * SUBTYPE OF (IfcCartesianTransformationOperator);
 * Axis3 : OPTIONAL IfcDirection;
 * DERIVE
 * U : LIST [3:3] OF IfcDirection := IfcBaseAxis(3,SELF\IfcCartesianTransformationOperator.Axis1,
 * SELF\IfcCartesianTransformationOperator.Axis2,Axis3);
 * WHERE
 * DimIs3D : SELF\IfcCartesianTransformationOperator.Dim = 3;
 * Axis1Is3D : NOT(EXISTS(SELF\IfcCartesianTransformationOperator.Axis1)) OR
 * (SELF\IfcCartesianTransformationOperator.Axis1.Dim = 3);
 * Axis2Is3D : NOT(EXISTS(SELF\IfcCartesianTransformationOperator.Axis2)) OR
 * (SELF\IfcCartesianTransformationOperator.Axis2.Dim = 3);
 * Axis3Is3D : NOT(EXISTS(Axis3)) OR (Axis3.Dim = 3);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccartesiantransformationoperator3dnonuniform.htm">IfcCartesianTransformationOperator3DnonUniform</a>
 */
public class IfcCartesianTransformationOperator3DnonUniform extends IfcCartesianTransformationOperator3D {
    protected IfcReal scale2;
    protected IfcReal scale3;

    protected IfcCartesianTransformationOperator3DnonUniform() { initCollections(); }
    /**
     * Constructs IfcCartesianTransformationOperator3DnonUniform with all required attributes.
     */
    public IfcCartesianTransformationOperator3DnonUniform(IfcCartesianPoint localOrigin) {

        super(localOrigin);
    }
    /**
     * Constructs IfcCartesianTransformationOperator3DnonUniform with required and optional attributes.
     */
    public IfcCartesianTransformationOperator3DnonUniform(IfcDirection axis1,IfcDirection axis2,IfcCartesianPoint localOrigin,IfcReal scale,IfcDirection axis3,IfcReal scale2,IfcReal scale3) {
        super(axis1,axis2,localOrigin,scale,axis3);
        this.scale2 = scale2;
        this.scale3 = scale3;
    }
    private void initCollections() {
    }
    public IfcReal getScale2() { return this.scale2; }
    public void setScale2(IfcReal value) { this.scale2 = value; } // optional
    public IfcReal getScale3() { return this.scale3; }
    public void setScale3(IfcReal value) { this.scale3 = value; } // optional
    public IfcReal getScl2() { throw new UnsupportedOperationException("Derived property logic has been implemented for Scl2."); } // derived
    public IfcReal getScl3() { throw new UnsupportedOperationException("Derived property logic has been implemented for Scl3."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(axis1 != null ? StepUtils.toStepValue(axis1) : "$");
		parameters.add(axis2 != null ? StepUtils.toStepValue(axis2) : "$");
		parameters.add(localOrigin != null ? StepUtils.toStepValue(localOrigin) : "$");
		parameters.add(scale != null ? StepUtils.toStepValue(scale) : "$");
		parameters.add(axis3 != null ? StepUtils.toStepValue(axis3) : "$");
		parameters.add(scale2 != null ? StepUtils.toStepValue(scale2) : "$");
		parameters.add(scale3 != null ? StepUtils.toStepValue(scale3) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}