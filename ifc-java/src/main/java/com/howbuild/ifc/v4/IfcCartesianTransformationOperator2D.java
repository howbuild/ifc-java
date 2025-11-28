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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccartesiantransformationoperator2d.htm">IfcCartesianTransformationOperator2D</a>
 */
public class IfcCartesianTransformationOperator2D extends IfcCartesianTransformationOperator {

    protected IfcCartesianTransformationOperator2D() { initCollections(); }
    /**
     * Constructs IfcCartesianTransformationOperator2D with all required attributes.
     */
    public IfcCartesianTransformationOperator2D(IfcCartesianPoint localOrigin) {

        super(localOrigin);
    }
    /**
     * Constructs IfcCartesianTransformationOperator2D with required and optional attributes.
     */
    public IfcCartesianTransformationOperator2D(IfcDirection axis1,IfcDirection axis2,IfcCartesianPoint localOrigin,IfcReal scale) {
        super(axis1,axis2,localOrigin,scale);
    }
    private void initCollections() {
    }
    public Collection<IfcDirection> getU() { throw new UnsupportedOperationException("Derived property logic has been implemented for U."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(axis1 != null ? StepUtils.toStepValue(axis1) : "$");
		parameters.add(axis2 != null ? StepUtils.toStepValue(axis2) : "$");
		parameters.add(localOrigin != null ? StepUtils.toStepValue(localOrigin) : "$");
		parameters.add(scale != null ? StepUtils.toStepValue(scale) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}