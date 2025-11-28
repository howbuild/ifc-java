package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFixedReferenceSweptAreaSolid
 * SUBTYPE OF (IfcSweptAreaSolid);
 * Directrix : IfcCurve;
 * StartParam : OPTIONAL IfcParameterValue;
 * EndParam : OPTIONAL IfcParameterValue;
 * FixedReference : IfcDirection;
 * WHERE
 * DirectrixBounded : (EXISTS(StartParam) AND EXISTS(EndParam)) OR
 * (SIZEOF(['IFC4.IFCCONIC', 'IFC4.IFCBOUNDEDCURVE'] * TYPEOF(Directrix)) = 1);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfixedreferencesweptareasolid.htm">IfcFixedReferenceSweptAreaSolid</a>
 */
public class IfcFixedReferenceSweptAreaSolid extends IfcSweptAreaSolid {
    protected IfcCurve directrix;
    protected IfcParameterValue startParam;
    protected IfcParameterValue endParam;
    protected IfcDirection fixedReference;

    protected IfcFixedReferenceSweptAreaSolid() { initCollections(); }
    /**
     * Constructs IfcFixedReferenceSweptAreaSolid with all required attributes.
     */
    public IfcFixedReferenceSweptAreaSolid(IfcProfileDef sweptArea,IfcCurve directrix,IfcDirection fixedReference) {

        super(sweptArea);
        this.directrix = directrix;
        this.fixedReference = fixedReference;
    }
    /**
     * Constructs IfcFixedReferenceSweptAreaSolid with required and optional attributes.
     */
    public IfcFixedReferenceSweptAreaSolid(IfcProfileDef sweptArea,IfcAxis2Placement3D position,IfcCurve directrix,IfcParameterValue startParam,IfcParameterValue endParam,IfcDirection fixedReference) {
        super(sweptArea,position);
        this.directrix = directrix;
        this.startParam = startParam;
        this.endParam = endParam;
        this.fixedReference = fixedReference;
    }
    private void initCollections() {
    }
    public IfcCurve getDirectrix() { return this.directrix; }
    public void setDirectrix(IfcCurve value) { this.directrix = value; }
    public IfcParameterValue getStartParam() { return this.startParam; }
    public void setStartParam(IfcParameterValue value) { this.startParam = value; } // optional
    public IfcParameterValue getEndParam() { return this.endParam; }
    public void setEndParam(IfcParameterValue value) { this.endParam = value; } // optional
    public IfcDirection getFixedReference() { return this.fixedReference; }
    public void setFixedReference(IfcDirection value) { this.fixedReference = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(sweptArea != null ? StepUtils.toStepValue(sweptArea) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(directrix != null ? StepUtils.toStepValue(directrix) : "$");
		parameters.add(startParam != null ? StepUtils.toStepValue(startParam) : "$");
		parameters.add(endParam != null ? StepUtils.toStepValue(endParam) : "$");
		parameters.add(fixedReference != null ? StepUtils.toStepValue(fixedReference) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}