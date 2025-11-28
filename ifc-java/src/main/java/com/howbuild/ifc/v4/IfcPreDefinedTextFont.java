package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPreDefinedItem
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcPreDefinedColour
 * ,IfcPreDefinedCurveFont
 * ,IfcPreDefinedTextFont))
 * SUBTYPE OF (IfcPresentationItem);
 * Name : IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpredefinedtextfont.htm">IfcPreDefinedTextFont</a>
 */
public abstract class IfcPreDefinedTextFont extends IfcPreDefinedItem implements IfcTextFontSelect {

    protected IfcPreDefinedTextFont() { initCollections(); }
    /**
     * Constructs IfcPreDefinedTextFont with all required attributes.
     */
    public IfcPreDefinedTextFont(IfcLabel name) {
        super(name);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}