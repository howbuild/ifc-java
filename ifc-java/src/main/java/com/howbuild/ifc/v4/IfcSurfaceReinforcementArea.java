package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralLoadOrResult
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcStructuralLoadStatic
 * ,IfcSurfaceReinforcementArea))
 * SUBTYPE OF (IfcStructuralLoad);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurfacereinforcementarea.htm">IfcSurfaceReinforcementArea</a>
 */
public class IfcSurfaceReinforcementArea extends IfcStructuralLoadOrResult {
    protected Collection<IfcLengthMeasure> surfaceReinforcement1;
    protected Collection<IfcLengthMeasure> surfaceReinforcement2;
    protected IfcRatioMeasure shearReinforcement;


    /**
     * Constructs IfcSurfaceReinforcementArea with all required attributes.
     */
    public IfcSurfaceReinforcementArea() {

        super();
        this.surfaceReinforcement1 = new ArrayList<>();
        this.surfaceReinforcement2 = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcSurfaceReinforcementArea with required and optional attributes.
     */
    public IfcSurfaceReinforcementArea(IfcLabel name,Collection<IfcLengthMeasure> surfaceReinforcement1,Collection<IfcLengthMeasure> surfaceReinforcement2,IfcRatioMeasure shearReinforcement) {
        super(name);
        this.surfaceReinforcement1 = surfaceReinforcement1;
        this.surfaceReinforcement2 = surfaceReinforcement2;
        this.shearReinforcement = shearReinforcement;
    }
    private void initCollections() {
        this.surfaceReinforcement1 = new ArrayList<>();
        this.surfaceReinforcement2 = new ArrayList<>();
    }
    public Collection<IfcLengthMeasure> getSurfaceReinforcement1() { return this.surfaceReinforcement1; }
    public void setSurfaceReinforcement1(Collection<IfcLengthMeasure> value) { this.surfaceReinforcement1 = value; } // optional
    public Collection<IfcLengthMeasure> getSurfaceReinforcement2() { return this.surfaceReinforcement2; }
    public void setSurfaceReinforcement2(Collection<IfcLengthMeasure> value) { this.surfaceReinforcement2 = value; } // optional
    public IfcRatioMeasure getShearReinforcement() { return this.shearReinforcement; }
    public void setShearReinforcement(IfcRatioMeasure value) { this.shearReinforcement = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(surfaceReinforcement1 != null ? StepUtils.toStepValue(surfaceReinforcement1) : "$");
		parameters.add(surfaceReinforcement2 != null ? StepUtils.toStepValue(surfaceReinforcement2) : "$");
		parameters.add(shearReinforcement != null ? StepUtils.toStepValue(shearReinforcement) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}