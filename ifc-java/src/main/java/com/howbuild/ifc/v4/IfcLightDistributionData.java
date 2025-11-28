package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcLightDistributionData;
 * MainPlaneAngle : IfcPlaneAngleMeasure;
 * SecondaryPlaneAngle : LIST [1:?] OF IfcPlaneAngleMeasure;
 * LuminousIntensity : LIST [1:?] OF IfcLuminousIntensityDistributionMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclightdistributiondata.htm">IfcLightDistributionData</a>
 */
public class IfcLightDistributionData extends BaseIfc {
    protected IfcPlaneAngleMeasure mainPlaneAngle;
    protected Collection<IfcPlaneAngleMeasure> secondaryPlaneAngle;
    protected Collection<IfcLuminousIntensityDistributionMeasure> luminousIntensity;

    protected IfcLightDistributionData() { initCollections(); }
    /**
     * Constructs IfcLightDistributionData with all required attributes.
     */
    public IfcLightDistributionData(IfcPlaneAngleMeasure mainPlaneAngle,Collection<IfcPlaneAngleMeasure> secondaryPlaneAngle,Collection<IfcLuminousIntensityDistributionMeasure> luminousIntensity) {
        super();
        this.mainPlaneAngle = mainPlaneAngle;
        this.secondaryPlaneAngle = secondaryPlaneAngle;
        this.luminousIntensity = luminousIntensity;
    }
    private void initCollections() {
        this.secondaryPlaneAngle = new ArrayList<>();
        this.luminousIntensity = new ArrayList<>();
    }
    public IfcPlaneAngleMeasure getMainPlaneAngle() { return this.mainPlaneAngle; }
    public void setMainPlaneAngle(IfcPlaneAngleMeasure value) { this.mainPlaneAngle = value; }
    public Collection<IfcPlaneAngleMeasure> getSecondaryPlaneAngle() { return this.secondaryPlaneAngle; }
    public void setSecondaryPlaneAngle(Collection<IfcPlaneAngleMeasure> value) { this.secondaryPlaneAngle = value; }
    public Collection<IfcLuminousIntensityDistributionMeasure> getLuminousIntensity() { return this.luminousIntensity; }
    public void setLuminousIntensity(Collection<IfcLuminousIntensityDistributionMeasure> value) { this.luminousIntensity = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(mainPlaneAngle != null ? StepUtils.toStepValue(mainPlaneAngle) : "$");
		parameters.add(secondaryPlaneAngle != null ? StepUtils.toStepValue(secondaryPlaneAngle) : "$");
		parameters.add(luminousIntensity != null ? StepUtils.toStepValue(luminousIntensity) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}