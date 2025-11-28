package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcSolidModel
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcCsgSolid
 * ,IfcManifoldSolidBrep
 * ,IfcSweptAreaSolid
 * ,IfcSweptDiskSolid))
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * DERIVE
 * Dim : IfcDimensionCount := 3;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsweptdisksolid.htm">IfcSweptDiskSolid</a>
 */
public class IfcSweptDiskSolid extends IfcSolidModel {
    protected IfcCurve directrix;
    protected IfcPositiveLengthMeasure radius;
    protected IfcPositiveLengthMeasure innerRadius;
    protected IfcParameterValue startParam;
    protected IfcParameterValue endParam;

    protected IfcSweptDiskSolid() { initCollections(); }
    /**
     * Constructs IfcSweptDiskSolid with all required attributes.
     */
    public IfcSweptDiskSolid(IfcCurve directrix,IfcPositiveLengthMeasure radius) {

        super();
        this.directrix = directrix;
        this.radius = radius;
    }
    /**
     * Constructs IfcSweptDiskSolid with required and optional attributes.
     */
    public IfcSweptDiskSolid(IfcCurve directrix,IfcPositiveLengthMeasure radius,IfcPositiveLengthMeasure innerRadius,IfcParameterValue startParam,IfcParameterValue endParam) {
        super();
        this.directrix = directrix;
        this.radius = radius;
        this.innerRadius = innerRadius;
        this.startParam = startParam;
        this.endParam = endParam;
    }
    private void initCollections() {
    }
    public IfcCurve getDirectrix() { return this.directrix; }
    public void setDirectrix(IfcCurve value) { this.directrix = value; }
    public IfcPositiveLengthMeasure getRadius() { return this.radius; }
    public void setRadius(IfcPositiveLengthMeasure value) { this.radius = value; }
    public IfcPositiveLengthMeasure getInnerRadius() { return this.innerRadius; }
    public void setInnerRadius(IfcPositiveLengthMeasure value) { this.innerRadius = value; } // optional
    public IfcParameterValue getStartParam() { return this.startParam; }
    public void setStartParam(IfcParameterValue value) { this.startParam = value; } // optional
    public IfcParameterValue getEndParam() { return this.endParam; }
    public void setEndParam(IfcParameterValue value) { this.endParam = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(directrix != null ? StepUtils.toStepValue(directrix) : "$");
		parameters.add(radius != null ? StepUtils.toStepValue(radius) : "$");
		parameters.add(innerRadius != null ? StepUtils.toStepValue(innerRadius) : "$");
		parameters.add(startParam != null ? StepUtils.toStepValue(startParam) : "$");
		parameters.add(endParam != null ? StepUtils.toStepValue(endParam) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}