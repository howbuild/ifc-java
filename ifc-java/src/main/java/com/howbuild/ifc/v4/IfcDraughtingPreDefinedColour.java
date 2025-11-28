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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdraughtingpredefinedcolour.htm">IfcDraughtingPreDefinedColour</a>
 */
public class IfcDraughtingPreDefinedColour extends IfcPreDefinedColour {

    protected IfcDraughtingPreDefinedColour() { initCollections(); }
    /**
     * Constructs IfcDraughtingPreDefinedColour with all required attributes.
     */
    public IfcDraughtingPreDefinedColour(IfcLabel name) {
        super(name);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}