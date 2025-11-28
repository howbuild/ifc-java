package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcColourRgbList
 * SUBTYPE OF (IfcPresentationItem);
 * ColourList : LIST [1:?] OF LIST [3:3] OF IfcNormalisedRatioMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpresentationitem.htm">IfcPresentationItem</a>
 */
public abstract class IfcPresentationItem extends BaseIfc {


    /**
     * Constructs IfcPresentationItem with all required attributes.
     */
    public IfcPresentationItem() {
        super();
        initCollections();
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}