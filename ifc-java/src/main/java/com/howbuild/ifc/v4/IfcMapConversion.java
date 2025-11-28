package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCoordinateOperation
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcMapConversion));
 * SourceCRS : IfcCoordinateReferenceSystemSelect;
 * TargetCRS : IfcCoordinateReferenceSystem;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmapconversion.htm">IfcMapConversion</a>
 */
public class IfcMapConversion extends IfcCoordinateOperation {
    protected IfcLengthMeasure eastings;
    protected IfcLengthMeasure northings;
    protected IfcLengthMeasure orthogonalHeight;
    protected IfcReal xAxisAbscissa;
    protected IfcReal xAxisOrdinate;
    protected IfcReal scale;

    protected IfcMapConversion() { initCollections(); }
    /**
     * Constructs IfcMapConversion with all required attributes.
     */
    public IfcMapConversion(IfcCoordinateReferenceSystemSelect sourceCRS,IfcCoordinateReferenceSystem targetCRS,IfcLengthMeasure eastings,IfcLengthMeasure northings,IfcLengthMeasure orthogonalHeight) {

        super(sourceCRS,targetCRS);
        this.eastings = eastings;
        this.northings = northings;
        this.orthogonalHeight = orthogonalHeight;
    }
    /**
     * Constructs IfcMapConversion with required and optional attributes.
     */
    public IfcMapConversion(IfcCoordinateReferenceSystemSelect sourceCRS,IfcCoordinateReferenceSystem targetCRS,IfcLengthMeasure eastings,IfcLengthMeasure northings,IfcLengthMeasure orthogonalHeight,IfcReal xAxisAbscissa,IfcReal xAxisOrdinate,IfcReal scale) {
        super(sourceCRS,targetCRS);
        this.eastings = eastings;
        this.northings = northings;
        this.orthogonalHeight = orthogonalHeight;
        this.xAxisAbscissa = xAxisAbscissa;
        this.xAxisOrdinate = xAxisOrdinate;
        this.scale = scale;
    }
    private void initCollections() {
    }
    public IfcLengthMeasure getEastings() { return this.eastings; }
    public void setEastings(IfcLengthMeasure value) { this.eastings = value; }
    public IfcLengthMeasure getNorthings() { return this.northings; }
    public void setNorthings(IfcLengthMeasure value) { this.northings = value; }
    public IfcLengthMeasure getOrthogonalHeight() { return this.orthogonalHeight; }
    public void setOrthogonalHeight(IfcLengthMeasure value) { this.orthogonalHeight = value; }
    public IfcReal getXAxisAbscissa() { return this.xAxisAbscissa; }
    public void setXAxisAbscissa(IfcReal value) { this.xAxisAbscissa = value; } // optional
    public IfcReal getXAxisOrdinate() { return this.xAxisOrdinate; }
    public void setXAxisOrdinate(IfcReal value) { this.xAxisOrdinate = value; } // optional
    public IfcReal getScale() { return this.scale; }
    public void setScale(IfcReal value) { this.scale = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(sourceCRS != null ? StepUtils.toStepValue(sourceCRS) : "$");
		parameters.add(targetCRS != null ? StepUtils.toStepValue(targetCRS) : "$");
		parameters.add(eastings != null ? StepUtils.toStepValue(eastings) : "$");
		parameters.add(northings != null ? StepUtils.toStepValue(northings) : "$");
		parameters.add(orthogonalHeight != null ? StepUtils.toStepValue(orthogonalHeight) : "$");
		parameters.add(xAxisAbscissa != null ? StepUtils.toStepValue(xAxisAbscissa) : "$");
		parameters.add(xAxisOrdinate != null ? StepUtils.toStepValue(xAxisOrdinate) : "$");
		parameters.add(scale != null ? StepUtils.toStepValue(scale) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}