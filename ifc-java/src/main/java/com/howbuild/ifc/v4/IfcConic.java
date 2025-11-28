package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCircle
 * SUBTYPE OF (IfcConic);
 * Radius : IfcPositiveLengthMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcconic.htm">IfcConic</a>
 */
public abstract class IfcConic extends IfcCurve {
    protected IfcAxis2Placement position;

    protected IfcConic() { initCollections(); }
    /**
     * Constructs IfcConic with all required attributes.
     */
    public IfcConic(IfcAxis2Placement position) {
        super();
        this.position = position;
    }
    private void initCollections() {
    }
    public IfcAxis2Placement getPosition() { return this.position; }
    public void setPosition(IfcAxis2Placement value) { this.position = value; }


    // inherits no-op finalizeRelationships from BaseIfc

}