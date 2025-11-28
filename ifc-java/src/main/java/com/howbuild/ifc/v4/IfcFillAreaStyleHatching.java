package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFillAreaStyleHatching
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * HatchLineAppearance : IfcCurveStyle;
 * StartOfNextHatchLine : IfcHatchLineDistanceSelect;
 * PointOfReferenceHatchLine : OPTIONAL IfcCartesianPoint;
 * PatternStart : OPTIONAL IfcCartesianPoint;
 * HatchLineAngle : IfcPlaneAngleMeasure;
 * WHERE
 * PatternStart2D : NOT(EXISTS(PatternStart)) OR (PatternStart.Dim = 2);
 * RefHatchLine2D : NOT(EXISTS(PointOfReferenceHatchLine)) OR (PointOfReferenceHatchLine.Dim = 2);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfillareastylehatching.htm">IfcFillAreaStyleHatching</a>
 */
public class IfcFillAreaStyleHatching extends IfcGeometricRepresentationItem implements IfcFillStyleSelect {
    protected IfcCurveStyle hatchLineAppearance;
    protected IfcHatchLineDistanceSelect startOfNextHatchLine;
    protected IfcCartesianPoint pointOfReferenceHatchLine;
    protected IfcCartesianPoint patternStart;
    protected IfcPlaneAngleMeasure hatchLineAngle;

    protected IfcFillAreaStyleHatching() { initCollections(); }
    /**
     * Constructs IfcFillAreaStyleHatching with all required attributes.
     */
    public IfcFillAreaStyleHatching(IfcCurveStyle hatchLineAppearance,IfcHatchLineDistanceSelect startOfNextHatchLine,IfcPlaneAngleMeasure hatchLineAngle) {

        super();
        this.hatchLineAppearance = hatchLineAppearance;
        this.startOfNextHatchLine = startOfNextHatchLine;
        this.hatchLineAngle = hatchLineAngle;
    }
    /**
     * Constructs IfcFillAreaStyleHatching with required and optional attributes.
     */
    public IfcFillAreaStyleHatching(IfcCurveStyle hatchLineAppearance,IfcHatchLineDistanceSelect startOfNextHatchLine,IfcCartesianPoint pointOfReferenceHatchLine,IfcCartesianPoint patternStart,IfcPlaneAngleMeasure hatchLineAngle) {
        super();
        this.hatchLineAppearance = hatchLineAppearance;
        this.startOfNextHatchLine = startOfNextHatchLine;
        this.pointOfReferenceHatchLine = pointOfReferenceHatchLine;
        this.patternStart = patternStart;
        this.hatchLineAngle = hatchLineAngle;
    }
    private void initCollections() {
    }
    public IfcCurveStyle getHatchLineAppearance() { return this.hatchLineAppearance; }
    public void setHatchLineAppearance(IfcCurveStyle value) { this.hatchLineAppearance = value; }
    public IfcHatchLineDistanceSelect getStartOfNextHatchLine() { return this.startOfNextHatchLine; }
    public void setStartOfNextHatchLine(IfcHatchLineDistanceSelect value) { this.startOfNextHatchLine = value; }
    public IfcCartesianPoint getPointOfReferenceHatchLine() { return this.pointOfReferenceHatchLine; }
    public void setPointOfReferenceHatchLine(IfcCartesianPoint value) { this.pointOfReferenceHatchLine = value; } // optional
    public IfcCartesianPoint getPatternStart() { return this.patternStart; }
    public void setPatternStart(IfcCartesianPoint value) { this.patternStart = value; } // optional
    public IfcPlaneAngleMeasure getHatchLineAngle() { return this.hatchLineAngle; }
    public void setHatchLineAngle(IfcPlaneAngleMeasure value) { this.hatchLineAngle = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(hatchLineAppearance != null ? StepUtils.toStepValue(hatchLineAppearance) : "$");
		parameters.add(startOfNextHatchLine != null ? StepUtils.toStepValue(startOfNextHatchLine) : "$");
		parameters.add(pointOfReferenceHatchLine != null ? StepUtils.toStepValue(pointOfReferenceHatchLine) : "$");
		parameters.add(patternStart != null ? StepUtils.toStepValue(patternStart) : "$");
		parameters.add(hatchLineAngle != null ? StepUtils.toStepValue(hatchLineAngle) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}