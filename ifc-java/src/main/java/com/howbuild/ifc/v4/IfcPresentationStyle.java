package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCurveStyle
 * SUBTYPE OF (IfcPresentationStyle);
 * CurveFont : OPTIONAL IfcCurveFontOrScaledCurveFontSelect;
 * CurveWidth : OPTIONAL IfcSizeSelect;
 * CurveColour : OPTIONAL IfcColour;
 * ModelOrDraughting : OPTIONAL IfcBoolean;
 * WHERE
 * MeasureOfWidth : (NOT(EXISTS(CurveWidth))) OR
 * ('IFC4.IFCPOSITIVELENGTHMEASURE' IN TYPEOF(CurveWidth)) OR
 * (('IFC4.IFCDESCRIPTIVEMEASURE' IN TYPEOF(CurveWidth)) AND
 * (CurveWidth = 'by layer'));
 * IdentifiableCurveStyle : EXISTS(CurveFont) OR EXISTS(CurveWidth) OR EXISTS(CurveColour);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpresentationstyle.htm">IfcPresentationStyle</a>
 */
public abstract class IfcPresentationStyle extends BaseIfc implements IfcStyleAssignmentSelect {
    protected IfcLabel name;


    /**
     * Constructs IfcPresentationStyle with all required attributes.
     */
    public IfcPresentationStyle() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcPresentationStyle with required and optional attributes.
     */
    public IfcPresentationStyle(IfcLabel name) {
        super();
        this.name = name;
    }
    private void initCollections() {
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}