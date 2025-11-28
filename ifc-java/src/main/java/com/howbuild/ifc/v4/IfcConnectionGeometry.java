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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcconnectiongeometry.htm">IfcConnectionGeometry</a>
 */
public abstract class IfcConnectionGeometry extends BaseIfc {


    /**
     * Constructs IfcConnectionGeometry with all required attributes.
     */
    public IfcConnectionGeometry() {
        super();
        initCollections();
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}