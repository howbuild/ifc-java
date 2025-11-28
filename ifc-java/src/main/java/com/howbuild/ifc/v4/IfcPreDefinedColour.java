package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDraughtingPreDefinedColour
 * SUBTYPE OF (IfcPreDefinedColour);
 * WHERE
 * PreDefinedColourNames : SELF\IfcPreDefinedItem.Name IN ['black','red','green','blue','yellow',
 * 'magenta','cyan','white','by layer'];
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpredefinedcolour.htm">IfcPreDefinedColour</a>
 */
public abstract class IfcPreDefinedColour extends IfcPreDefinedItem implements IfcColour {

    protected IfcPreDefinedColour() { initCollections(); }
    /**
     * Constructs IfcPreDefinedColour with all required attributes.
     */
    public IfcPreDefinedColour(IfcLabel name) {
        super(name);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}