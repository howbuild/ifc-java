package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcColourRgb
 * SUBTYPE OF (IfcColourSpecification);
 * Red : IfcNormalisedRatioMeasure;
 * Green : IfcNormalisedRatioMeasure;
 * Blue : IfcNormalisedRatioMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccolourspecification.htm">IfcColourSpecification</a>
 */
public abstract class IfcColourSpecification extends IfcPresentationItem implements IfcColour {
    protected IfcLabel name;


    /**
     * Constructs IfcColourSpecification with all required attributes.
     */
    public IfcColourSpecification() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcColourSpecification with required and optional attributes.
     */
    public IfcColourSpecification(IfcLabel name) {
        super();
        this.name = name;
    }
    private void initCollections() {
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}