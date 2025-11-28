package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDraughtingPreDefinedCurveFont
 * SUBTYPE OF (IfcPreDefinedCurveFont);
 * WHERE
 * PreDefinedCurveFontNames : SELF\IfcPredefinedItem.Name IN
 * ['continuous',
 * 'chain',
 * 'chain double dash',
 * 'dashed',
 * 'dotted',
 * 'by layer'];
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpredefinedcurvefont.htm">IfcPreDefinedCurveFont</a>
 */
public abstract class IfcPreDefinedCurveFont extends IfcPreDefinedItem implements IfcCurveStyleFontSelect {

    protected IfcPreDefinedCurveFont() { initCollections(); }
    /**
     * Constructs IfcPreDefinedCurveFont with all required attributes.
     */
    public IfcPreDefinedCurveFont(IfcLabel name) {
        super(name);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}