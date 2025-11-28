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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcdraughtingpredefinedcurvefont.htm">IfcDraughtingPreDefinedCurveFont</a>
 */
public class IfcDraughtingPreDefinedCurveFont extends IfcPreDefinedCurveFont {

    protected IfcDraughtingPreDefinedCurveFont() { initCollections(); }
    /**
     * Constructs IfcDraughtingPreDefinedCurveFont with all required attributes.
     */
    public IfcDraughtingPreDefinedCurveFont(IfcLabel name) {
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