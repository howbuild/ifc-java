package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcLightIntensityDistribution;
 * LightDistributionCurve : IfcLightDistributionCurveEnum;
 * DistributionData : LIST [1:?] OF IfcLightDistributionData;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclightintensitydistribution.htm">IfcLightIntensityDistribution</a>
 */
public class IfcLightIntensityDistribution extends BaseIfc implements IfcLightDistributionDataSourceSelect {
    protected IfcLightDistributionCurveEnum lightDistributionCurve;
    protected Collection<IfcLightDistributionData> distributionData;

    protected IfcLightIntensityDistribution() { initCollections(); }
    /**
     * Constructs IfcLightIntensityDistribution with all required attributes.
     */
    public IfcLightIntensityDistribution(IfcLightDistributionCurveEnum lightDistributionCurve,Collection<IfcLightDistributionData> distributionData) {
        super();
        this.lightDistributionCurve = lightDistributionCurve;
        this.distributionData = distributionData;
    }
    private void initCollections() {
        this.distributionData = new ArrayList<>();
    }
    public IfcLightDistributionCurveEnum getLightDistributionCurve() { return this.lightDistributionCurve; }
    public void setLightDistributionCurve(IfcLightDistributionCurveEnum value) { this.lightDistributionCurve = value; }
    public Collection<IfcLightDistributionData> getDistributionData() { return this.distributionData; }
    public void setDistributionData(Collection<IfcLightDistributionData> value) { this.distributionData = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(StepUtils.toStepValue(lightDistributionCurve));
		parameters.add(distributionData != null ? StepUtils.toStepValue(distributionData) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}