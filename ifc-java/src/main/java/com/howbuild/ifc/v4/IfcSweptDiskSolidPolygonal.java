package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSweptDiskSolid
 * SUPERTYPE OF (ONEOF
 * (IfcSweptDiskSolidPolygonal))
 * SUBTYPE OF (IfcSolidModel);
 * Directrix : IfcCurve;
 * Radius : IfcPositiveLengthMeasure;
 * InnerRadius : OPTIONAL IfcPositiveLengthMeasure;
 * StartParam : OPTIONAL IfcParameterValue;
 * EndParam : OPTIONAL IfcParameterValue;
 * WHERE
 * DirectrixDim : Directrix.Dim = 3;
 * InnerRadiusSize : (NOT EXISTS(InnerRadius)) OR (Radius > InnerRadius);
 * DirectrixBounded : (EXISTS(StartParam) AND EXISTS(EndParam)) OR
 * (SIZEOF(['IFC4.IFCCONIC', 'IFC4.IFCBOUNDEDCURVE'] * TYPEOF(Directrix)) = 1);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsweptdisksolidpolygonal.htm">IfcSweptDiskSolidPolygonal</a>
 */
public class IfcSweptDiskSolidPolygonal extends IfcSweptDiskSolid {
    protected IfcPositiveLengthMeasure filletRadius;

    protected IfcSweptDiskSolidPolygonal() { initCollections(); }
    /**
     * Constructs IfcSweptDiskSolidPolygonal with all required attributes.
     */
    public IfcSweptDiskSolidPolygonal(IfcCurve directrix,IfcPositiveLengthMeasure radius) {

        super(directrix,radius);
    }
    /**
     * Constructs IfcSweptDiskSolidPolygonal with required and optional attributes.
     */
    public IfcSweptDiskSolidPolygonal(IfcCurve directrix,IfcPositiveLengthMeasure radius,IfcPositiveLengthMeasure innerRadius,IfcParameterValue startParam,IfcParameterValue endParam,IfcPositiveLengthMeasure filletRadius) {
        super(directrix,radius,innerRadius,startParam,endParam);
        this.filletRadius = filletRadius;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getFilletRadius() { return this.filletRadius; }
    public void setFilletRadius(IfcPositiveLengthMeasure value) { this.filletRadius = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(directrix != null ? StepUtils.toStepValue(directrix) : "$");
		parameters.add(radius != null ? StepUtils.toStepValue(radius) : "$");
		parameters.add(innerRadius != null ? StepUtils.toStepValue(innerRadius) : "$");
		parameters.add(startParam != null ? StepUtils.toStepValue(startParam) : "$");
		parameters.add(endParam != null ? StepUtils.toStepValue(endParam) : "$");
		parameters.add(filletRadius != null ? StepUtils.toStepValue(filletRadius) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}