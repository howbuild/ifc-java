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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccartesiantransformationoperator.htm">IfcCartesianTransformationOperator</a>
 */
public abstract class IfcCartesianTransformationOperator extends IfcGeometricRepresentationItem {
    protected IfcDirection axis1;
    protected IfcDirection axis2;
    protected IfcCartesianPoint localOrigin;
    protected IfcReal scale;

    protected IfcCartesianTransformationOperator() { initCollections(); }
    /**
     * Constructs IfcCartesianTransformationOperator with all required attributes.
     */
    public IfcCartesianTransformationOperator(IfcCartesianPoint localOrigin) {

        super();
        this.localOrigin = localOrigin;
    }
    /**
     * Constructs IfcCartesianTransformationOperator with required and optional attributes.
     */
    public IfcCartesianTransformationOperator(IfcDirection axis1,IfcDirection axis2,IfcCartesianPoint localOrigin,IfcReal scale) {
        super();
        this.axis1 = axis1;
        this.axis2 = axis2;
        this.localOrigin = localOrigin;
        this.scale = scale;
    }
    private void initCollections() {
    }
    public IfcDirection getAxis1() { return this.axis1; }
    public void setAxis1(IfcDirection value) { this.axis1 = value; } // optional
    public IfcDirection getAxis2() { return this.axis2; }
    public void setAxis2(IfcDirection value) { this.axis2 = value; } // optional
    public IfcCartesianPoint getLocalOrigin() { return this.localOrigin; }
    public void setLocalOrigin(IfcCartesianPoint value) { this.localOrigin = value; }
    public IfcReal getScale() { return this.scale; }
    public void setScale(IfcReal value) { this.scale = value; } // optional
    public IfcReal getScl() { throw new UnsupportedOperationException("Derived property logic has been implemented for Scl."); } // derived
    public IfcDimensionCount getDim() { throw new UnsupportedOperationException("Derived property logic has been implemented for Dim."); } // derived


    // inherits no-op finalizeRelationships from BaseIfc

}