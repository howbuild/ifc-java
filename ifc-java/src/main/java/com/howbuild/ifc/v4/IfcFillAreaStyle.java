package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFillAreaStyle
 * SUBTYPE OF (IfcPresentationStyle);
 * FillStyles : SET [1:?] OF IfcFillStyleSelect;
 * ModelorDraughting : OPTIONAL IfcBoolean;
 * WHERE
 * MaxOneColour : SIZEOF(QUERY(Style <* SELF.FillStyles |
 * 'IFC4.IFCCOLOUR' IN
 * TYPEOF(Style)
 * )) <= 1;
 * MaxOneExtHatchStyle : SIZEOF(QUERY(Style <* SELF.FillStyles |
 * 'IFC4.IFCEXTERNALLYDEFINEDHATCHSTYLE' IN
 * TYPEOF(Style)
 * )) <= 1;
 * ConsistentHatchStyleDef : IfcCorrectFillAreaStyle(SELF.FillStyles);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfillareastyle.htm">IfcFillAreaStyle</a>
 */
public class IfcFillAreaStyle extends IfcPresentationStyle implements IfcPresentationStyleSelect {
    protected Collection<IfcFillStyleSelect> fillStyles;
    protected IfcBoolean modelorDraughting;

    protected IfcFillAreaStyle() { initCollections(); }
    /**
     * Constructs IfcFillAreaStyle with all required attributes.
     */
    public IfcFillAreaStyle(Collection<IfcFillStyleSelect> fillStyles) {

        super();
        this.fillStyles = fillStyles;
    }
    /**
     * Constructs IfcFillAreaStyle with required and optional attributes.
     */
    public IfcFillAreaStyle(IfcLabel name,Collection<IfcFillStyleSelect> fillStyles,IfcBoolean modelorDraughting) {
        super(name);
        this.fillStyles = fillStyles;
        this.modelorDraughting = modelorDraughting;
    }
    private void initCollections() {
        this.fillStyles = new ArrayList<>();
    }
    public Collection<IfcFillStyleSelect> getFillStyles() { return this.fillStyles; }
    public void setFillStyles(Collection<IfcFillStyleSelect> value) { this.fillStyles = value; }
    public IfcBoolean getModelorDraughting() { return this.modelorDraughting; }
    public void setModelorDraughting(IfcBoolean value) { this.modelorDraughting = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(fillStyles != null ? StepUtils.toStepValue(fillStyles) : "$");
		parameters.add(modelorDraughting != null ? StepUtils.toStepValue(modelorDraughting) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}