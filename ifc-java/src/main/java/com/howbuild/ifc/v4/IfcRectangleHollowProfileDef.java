package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRectangleHollowProfileDef
 * SUBTYPE OF (IfcRectangleProfileDef);
 * WallThickness : IfcPositiveLengthMeasure;
 * InnerFilletRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * OuterFilletRadius : OPTIONAL IfcNonNegativeLengthMeasure;
 * WHERE
 * ValidWallThickness : (WallThickness < (SELF\IfcRectangleProfileDef.XDim/2.)) AND
 * (WallThickness < (SELF\IfcRectangleProfileDef.YDim/2.));
 * ValidInnerRadius : NOT(EXISTS(InnerFilletRadius)) OR
 * ((InnerFilletRadius <= (SELF\IfcRectangleProfileDef.XDim/2. - WallThickness)) AND
 * (InnerFilletRadius <= (SELF\IfcRectangleProfileDef.YDim/2. - WallThickness)));
 * ValidOuterRadius : NOT(EXISTS(OuterFilletRadius)) OR
 * ((OuterFilletRadius <= (SELF\IfcRectangleProfileDef.XDim/2.)) AND
 * (OuterFilletRadius <= (SELF\IfcRectangleProfileDef.YDim/2.)));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrectanglehollowprofiledef.htm">IfcRectangleHollowProfileDef</a>
 */
public class IfcRectangleHollowProfileDef extends IfcRectangleProfileDef {
    protected IfcPositiveLengthMeasure wallThickness;
    protected IfcNonNegativeLengthMeasure innerFilletRadius;
    protected IfcNonNegativeLengthMeasure outerFilletRadius;

    protected IfcRectangleHollowProfileDef() { initCollections(); }
    /**
     * Constructs IfcRectangleHollowProfileDef with all required attributes.
     */
    public IfcRectangleHollowProfileDef(IfcProfileTypeEnum profileType,IfcPositiveLengthMeasure xDim,IfcPositiveLengthMeasure yDim,IfcPositiveLengthMeasure wallThickness) {

        super(profileType,xDim,yDim);
        this.wallThickness = wallThickness;
    }
    /**
     * Constructs IfcRectangleHollowProfileDef with required and optional attributes.
     */
    public IfcRectangleHollowProfileDef(IfcProfileTypeEnum profileType,IfcLabel profileName,IfcAxis2Placement2D position,IfcPositiveLengthMeasure xDim,IfcPositiveLengthMeasure yDim,IfcPositiveLengthMeasure wallThickness,IfcNonNegativeLengthMeasure innerFilletRadius,IfcNonNegativeLengthMeasure outerFilletRadius) {
        super(profileType,profileName,position,xDim,yDim);
        this.wallThickness = wallThickness;
        this.innerFilletRadius = innerFilletRadius;
        this.outerFilletRadius = outerFilletRadius;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getWallThickness() { return this.wallThickness; }
    public void setWallThickness(IfcPositiveLengthMeasure value) { this.wallThickness = value; }
    public IfcNonNegativeLengthMeasure getInnerFilletRadius() { return this.innerFilletRadius; }
    public void setInnerFilletRadius(IfcNonNegativeLengthMeasure value) { this.innerFilletRadius = value; } // optional
    public IfcNonNegativeLengthMeasure getOuterFilletRadius() { return this.outerFilletRadius; }
    public void setOuterFilletRadius(IfcNonNegativeLengthMeasure value) { this.outerFilletRadius = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(profileType));
		parameters.add(profileName != null ? StepUtils.toStepValue(profileName) : "$");
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(xDim != null ? StepUtils.toStepValue(xDim) : "$");
		parameters.add(yDim != null ? StepUtils.toStepValue(yDim) : "$");
		parameters.add(wallThickness != null ? StepUtils.toStepValue(wallThickness) : "$");
		parameters.add(innerFilletRadius != null ? StepUtils.toStepValue(innerFilletRadius) : "$");
		parameters.add(outerFilletRadius != null ? StepUtils.toStepValue(outerFilletRadius) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}