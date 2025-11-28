package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcVirtualGridIntersection;
 * IntersectingAxes : LIST [2:2] OF UNIQUE IfcGridAxis;
 * OffsetDistances : LIST [2:3] OF IfcLengthMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcvirtualgridintersection.htm">IfcVirtualGridIntersection</a>
 */
public class IfcVirtualGridIntersection extends BaseIfc implements IfcGridPlacementDirectionSelect {
    protected Collection<IfcGridAxis> intersectingAxes;
    protected Collection<IfcLengthMeasure> offsetDistances;

    protected IfcVirtualGridIntersection() { initCollections(); }
    /**
     * Constructs IfcVirtualGridIntersection with all required attributes.
     */
    public IfcVirtualGridIntersection(Collection<IfcGridAxis> intersectingAxes,Collection<IfcLengthMeasure> offsetDistances) {
        super();
        this.intersectingAxes = intersectingAxes;
        this.offsetDistances = offsetDistances;
    }
    private void initCollections() {
        this.intersectingAxes = new ArrayList<>();
        this.offsetDistances = new ArrayList<>();
    }
    public Collection<IfcGridAxis> getIntersectingAxes() { return this.intersectingAxes; }
    public void setIntersectingAxes(Collection<IfcGridAxis> value) { this.intersectingAxes = value; }
    public Collection<IfcLengthMeasure> getOffsetDistances() { return this.offsetDistances; }
    public void setOffsetDistances(Collection<IfcLengthMeasure> value) { this.offsetDistances = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(intersectingAxes != null ? StepUtils.toStepValue(intersectingAxes) : "$");
		parameters.add(offsetDistances != null ? StepUtils.toStepValue(offsetDistances) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcVirtualGridIntersectionRelationship(); }
    private void setIfcVirtualGridIntersectionRelationship() {
		if (this.intersectingAxes != null) {
		    for (Object x : this.intersectingAxes) {
		        if (x instanceof IfcGridAxis)
		            ((IfcGridAxis)x).hasIntersections.add(this);
		    }
		}
    }
}