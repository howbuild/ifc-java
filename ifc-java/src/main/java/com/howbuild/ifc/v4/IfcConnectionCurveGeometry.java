package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConnectionCurveGeometry
 * SUBTYPE OF (IfcConnectionGeometry);
 * CurveOnRelatingElement : IfcCurveOrEdgeCurve;
 * CurveOnRelatedElement : OPTIONAL IfcCurveOrEdgeCurve;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcconnectioncurvegeometry.htm">IfcConnectionCurveGeometry</a>
 */
public class IfcConnectionCurveGeometry extends IfcConnectionGeometry {
    protected IfcCurveOrEdgeCurve curveOnRelatingElement;
    protected IfcCurveOrEdgeCurve curveOnRelatedElement;

    protected IfcConnectionCurveGeometry() { initCollections(); }
    /**
     * Constructs IfcConnectionCurveGeometry with all required attributes.
     */
    public IfcConnectionCurveGeometry(IfcCurveOrEdgeCurve curveOnRelatingElement) {

        super();
        this.curveOnRelatingElement = curveOnRelatingElement;
    }
    /**
     * Constructs IfcConnectionCurveGeometry with required and optional attributes.
     */
    public IfcConnectionCurveGeometry(IfcCurveOrEdgeCurve curveOnRelatingElement,IfcCurveOrEdgeCurve curveOnRelatedElement) {
        super();
        this.curveOnRelatingElement = curveOnRelatingElement;
        this.curveOnRelatedElement = curveOnRelatedElement;
    }
    private void initCollections() {
    }
    public IfcCurveOrEdgeCurve getCurveOnRelatingElement() { return this.curveOnRelatingElement; }
    public void setCurveOnRelatingElement(IfcCurveOrEdgeCurve value) { this.curveOnRelatingElement = value; }
    public IfcCurveOrEdgeCurve getCurveOnRelatedElement() { return this.curveOnRelatedElement; }
    public void setCurveOnRelatedElement(IfcCurveOrEdgeCurve value) { this.curveOnRelatedElement = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(curveOnRelatingElement != null ? StepUtils.toStepValue(curveOnRelatingElement) : "$");
		parameters.add(curveOnRelatedElement != null ? StepUtils.toStepValue(curveOnRelatedElement) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}