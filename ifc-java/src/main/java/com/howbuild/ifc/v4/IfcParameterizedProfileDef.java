package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcAsymmetricIShapeProfileDef
 * SUBTYPE OF (IfcParameterizedProfileDef);
 * BottomFlangeWidth : IfcPositiveLengthMeasure;
 * OverallDepth : IfcPositiveLengthMeasure;
 * WebThickness : IfcPositiveLengthMeasure;
 * BottomFlangeThickness : IfcPositiveLengthMeasure;
 * BottomFlangeFilletRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * TopFlangeWidth : IfcPositiveLengthMeasure;
 * TopFlangeThickness : OPTIONAL IfcPositiveLengthMeasure;
 * TopFlangeFilletRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * BottomFlangeEdgeRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * BottomFlangeSlope : OPTIONAL IfcPlaneAngleMeasure;
 * TopFlangeEdgeRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * TopFlangeSlope : OPTIONAL IfcPlaneAngleMeasure;
 * WHERE
 * ValidFlangeThickness : NOT(EXISTS(TopFlangeThickness)) OR ((BottomFlangeThickness + TopFlangeThickness) < OverallDepth);
 * ValidWebThickness : (WebThickness < BottomFlangeWidth) AND (WebThickness < TopFlangeWidth);
 * ValidBottomFilletRadius : (NOT(EXISTS(BottomFlangeFilletRadius))) OR
 * (BottomFlangeFilletRadius <= (BottomFlangeWidth - WebThickness)/2.);
 * ValidTopFilletRadius : (NOT(EXISTS(TopFlangeFilletRadius))) OR
 * (TopFlangeFilletRadius <= (TopFlangeWidth - WebThickness)/2.);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcparameterizedprofiledef.htm">IfcParameterizedProfileDef</a>
 */
public abstract class IfcParameterizedProfileDef extends IfcProfileDef {
    protected IfcAxis2Placement2D position;

    protected IfcParameterizedProfileDef() { initCollections(); }
    /**
     * Constructs IfcParameterizedProfileDef with all required attributes.
     */
    public IfcParameterizedProfileDef(IfcProfileTypeEnum profileType) {

        super(profileType);
    }
    /**
     * Constructs IfcParameterizedProfileDef with required and optional attributes.
     */
    public IfcParameterizedProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position) {
        super(profileType,profileName);
        this.position = position;
    }
    private void initCollections() {
    }
    public IfcAxis2Placement2D getPosition() { return this.position; }
    public void setPosition(IfcAxis2Placement2D value) { this.position = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}