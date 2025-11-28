package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBlock
 * SUBTYPE OF (IfcCsgPrimitive3D);
 * XLength : IfcPositiveLengthMeasure;
 * YLength : IfcPositiveLengthMeasure;
 * ZLength : IfcPositiveLengthMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcblock.htm">IfcBlock</a>
 */
public class IfcBlock extends IfcCsgPrimitive3D {
    protected IfcPositiveLengthMeasure xLength;
    protected IfcPositiveLengthMeasure yLength;
    protected IfcPositiveLengthMeasure zLength;

    protected IfcBlock() { initCollections(); }
    /**
     * Constructs IfcBlock with all required attributes.
     */
    public IfcBlock(IfcAxis2Placement3D position,IfcPositiveLengthMeasure xLength,IfcPositiveLengthMeasure yLength,IfcPositiveLengthMeasure zLength) {
        super(position);
        this.xLength = xLength;
        this.yLength = yLength;
        this.zLength = zLength;
    }
    private void initCollections() {
    }
    public IfcPositiveLengthMeasure getXLength() { return this.xLength; }
    public void setXLength(IfcPositiveLengthMeasure value) { this.xLength = value; }
    public IfcPositiveLengthMeasure getYLength() { return this.yLength; }
    public void setYLength(IfcPositiveLengthMeasure value) { this.yLength = value; }
    public IfcPositiveLengthMeasure getZLength() { return this.zLength; }
    public void setZLength(IfcPositiveLengthMeasure value) { this.zLength = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(position != null ? StepUtils.toStepValue(position) : "$");
		parameters.add(xLength != null ? StepUtils.toStepValue(xLength) : "$");
		parameters.add(yLength != null ? StepUtils.toStepValue(yLength) : "$");
		parameters.add(zLength != null ? StepUtils.toStepValue(zLength) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}