package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCartesianTransformationOperator2D
 * SUPERTYPE OF (ONEOF
 * (IfcCartesianTransformationOperator2DnonUniform))
 * SUBTYPE OF (IfcCartesianTransformationOperator);
 * DERIVE
 * U : LIST [2:2] OF IfcDirection := IfcBaseAxis(2,SELF\IfcCartesianTransformationOperator.Axis1,
 * SELF\IfcCartesianTransformationOperator.Axis2,?);
 * WHERE
 * DimEqual2 : SELF\IfcCartesianTransformationOperator.Dim = 2;
 * Axis1Is2D : NOT(EXISTS(SELF\IfcCartesianTransformationOperator.Axis1)) OR
 * (SELF\IfcCartesianTransformationOperator.Axis1.Dim = 2);
 * Axis2Is2D : NOT(EXISTS(SELF\IfcCartesianTransformationOperator.Axis2)) OR
 * (SELF\IfcCartesianTransformationOperator.Axis2.Dim = 2);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccartesiantransformationoperator2dnonuniform.htm">IfcCartesianTransformationOperator2DnonUniform</a>
 */
public class IfcCartesianTransformationOperator2DnonUniform extends IfcCartesianTransformationOperator2D {
    protected IfcReal scale2;

    protected IfcCartesianTransformationOperator2DnonUniform() { initCollections(); }
    /**
     * Constructs IfcCartesianTransformationOperator2DnonUniform with all required attributes.
     */
    public IfcCartesianTransformationOperator2DnonUniform(IfcCartesianPoint localOrigin) {

        super(localOrigin);
    }
    /**
     * Constructs IfcCartesianTransformationOperator2DnonUniform with required and optional attributes.
     */
    public IfcCartesianTransformationOperator2DnonUniform(IfcDirection axis1,IfcDirection axis2,IfcCartesianPoint localOrigin,IfcReal scale,IfcReal scale2) {
        super(axis1,axis2,localOrigin,scale);
        this.scale2 = scale2;
    }
    private void initCollections() {
    }
    public IfcReal getScale2() { return this.scale2; }
    public void setScale2(IfcReal value) { this.scale2 = value; } // optional
    public IfcReal getScl2() { throw new UnsupportedOperationException("Derived property logic has been implemented for Scl2."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(axis1 != null ? StepUtils.toStepValue(axis1) : "$");
		parameters.add(axis2 != null ? StepUtils.toStepValue(axis2) : "$");
		parameters.add(localOrigin != null ? StepUtils.toStepValue(localOrigin) : "$");
		parameters.add(scale != null ? StepUtils.toStepValue(scale) : "$");
		parameters.add(scale2 != null ? StepUtils.toStepValue(scale2) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}