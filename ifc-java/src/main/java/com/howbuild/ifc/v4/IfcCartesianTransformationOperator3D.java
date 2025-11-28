package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCartesianTransformationOperator
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcCartesianTransformationOperator2D
 * ,IfcCartesianTransformationOperator3D))
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * Axis1 : OPTIONAL IfcDirection;
 * Axis2 : OPTIONAL IfcDirection;
 * LocalOrigin : IfcCartesianPoint;
 * Scale : OPTIONAL IfcReal;
 * DERIVE
 * Scl : IfcReal := NVL(Scale, 1.0);
 * Dim : IfcDimensionCount := LocalOrigin.Dim;
 * WHERE
 * ScaleGreaterZero : Scl > 0.0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccartesiantransformationoperator3d.htm">IfcCartesianTransformationOperator3D</a>
 */
public class IfcCartesianTransformationOperator3D extends IfcCartesianTransformationOperator {
    protected IfcDirection axis3;

    protected IfcCartesianTransformationOperator3D() { initCollections(); }
    /**
     * Constructs IfcCartesianTransformationOperator3D with all required attributes.
     */
    public IfcCartesianTransformationOperator3D(IfcCartesianPoint localOrigin) {

        super(localOrigin);
    }
    /**
     * Constructs IfcCartesianTransformationOperator3D with required and optional attributes.
     */
    public IfcCartesianTransformationOperator3D(IfcDirection axis1,IfcDirection axis2,IfcCartesianPoint localOrigin,IfcReal scale,IfcDirection axis3) {
        super(axis1,axis2,localOrigin,scale);
        this.axis3 = axis3;
    }
    private void initCollections() {
    }
    public IfcDirection getAxis3() { return this.axis3; }
    public void setAxis3(IfcDirection value) { this.axis3 = value; } // optional
    public Collection<IfcDirection> getU() { throw new UnsupportedOperationException("Derived property logic has been implemented for U."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(axis1 != null ? StepUtils.toStepValue(axis1) : "$");
		parameters.add(axis2 != null ? StepUtils.toStepValue(axis2) : "$");
		parameters.add(localOrigin != null ? StepUtils.toStepValue(localOrigin) : "$");
		parameters.add(scale != null ? StepUtils.toStepValue(scale) : "$");
		parameters.add(axis3 != null ? StepUtils.toStepValue(axis3) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}