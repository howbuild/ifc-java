package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBSplineCurve
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcBSplineCurveWithKnots))
 * SUBTYPE OF (IfcBoundedCurve);
 * Degree : IfcInteger;
 * ControlPointsList : LIST [2:?] OF IfcCartesianPoint;
 * CurveForm : IfcBSplineCurveForm;
 * ClosedCurve : IfcLogical;
 * SelfIntersect : IfcLogical;
 * DERIVE
 * UpperIndexOnControlPoints : IfcInteger := (SIZEOF(ControlPointsList) - 1);
 * ControlPoints : ARRAY [0:UpperIndexOnControlPoints] OF IfcCartesianPoint := IfcListToArray(ControlPointsList,0,UpperIndexOnControlPoints);
 * WHERE
 * SameDim : SIZEOF(QUERY(Temp <* ControlPointsList |
 * Temp.Dim <> ControlPointsList[1].Dim))
 * = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcboundedcurve.htm">IfcBoundedCurve</a>
 */
public abstract class IfcBoundedCurve extends IfcCurve implements IfcCurveOrEdgeCurve {


    /**
     * Constructs IfcBoundedCurve with all required attributes.
     */
    public IfcBoundedCurve() {
        super();
        initCollections();
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}