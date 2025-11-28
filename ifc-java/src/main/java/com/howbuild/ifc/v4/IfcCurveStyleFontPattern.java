package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCurveStyleFontPattern
 * SUBTYPE OF (IfcPresentationItem);
 * VisibleSegmentLength : IfcLengthMeasure;
 * InvisibleSegmentLength : IfcPositiveLengthMeasure;
 * WHERE
 * VisibleLengthGreaterEqualZero : VisibleSegmentLength >= 0.;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccurvestylefontpattern.htm">IfcCurveStyleFontPattern</a>
 */
public class IfcCurveStyleFontPattern extends IfcPresentationItem {
    protected IfcLengthMeasure visibleSegmentLength;
    protected IfcPositiveLengthMeasure invisibleSegmentLength;

    protected IfcCurveStyleFontPattern() { initCollections(); }
    /**
     * Constructs IfcCurveStyleFontPattern with all required attributes.
     */
    public IfcCurveStyleFontPattern(IfcLengthMeasure visibleSegmentLength,IfcPositiveLengthMeasure invisibleSegmentLength) {
        super();
        this.visibleSegmentLength = visibleSegmentLength;
        this.invisibleSegmentLength = invisibleSegmentLength;
    }
    private void initCollections() {
    }
    public IfcLengthMeasure getVisibleSegmentLength() { return this.visibleSegmentLength; }
    public void setVisibleSegmentLength(IfcLengthMeasure value) { this.visibleSegmentLength = value; }
    public IfcPositiveLengthMeasure getInvisibleSegmentLength() { return this.invisibleSegmentLength; }
    public void setInvisibleSegmentLength(IfcPositiveLengthMeasure value) { this.invisibleSegmentLength = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(visibleSegmentLength != null ? StepUtils.toStepValue(visibleSegmentLength) : "$");
		parameters.add(invisibleSegmentLength != null ? StepUtils.toStepValue(invisibleSegmentLength) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}