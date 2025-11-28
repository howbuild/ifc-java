package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCurveStyleFont
 * SUBTYPE OF (IfcPresentationItem);
 * Name : OPTIONAL IfcLabel;
 * PatternList : LIST [1:?] OF IfcCurveStyleFontPattern;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccurvestylefont.htm">IfcCurveStyleFont</a>
 */
public class IfcCurveStyleFont extends IfcPresentationItem implements IfcCurveStyleFontSelect {
    protected IfcLabel name;
    protected Collection<IfcCurveStyleFontPattern> patternList;

    protected IfcCurveStyleFont() { initCollections(); }
    /**
     * Constructs IfcCurveStyleFont with all required attributes.
     */
    public IfcCurveStyleFont(Collection<IfcCurveStyleFontPattern> patternList) {

        super();
        this.patternList = patternList;
    }
    /**
     * Constructs IfcCurveStyleFont with required and optional attributes.
     */
    public IfcCurveStyleFont(IfcLabel name,Collection<IfcCurveStyleFontPattern> patternList) {
        super();
        this.name = name;
        this.patternList = patternList;
    }
    private void initCollections() {
        this.patternList = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public Collection<IfcCurveStyleFontPattern> getPatternList() { return this.patternList; }
    public void setPatternList(Collection<IfcCurveStyleFontPattern> value) { this.patternList = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(patternList != null ? StepUtils.toStepValue(patternList) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}