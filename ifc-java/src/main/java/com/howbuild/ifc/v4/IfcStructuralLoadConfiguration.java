package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralLoad
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcStructuralLoadConfiguration
 * ,IfcStructuralLoadOrResult));
 * Name : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralloadconfiguration.htm">IfcStructuralLoadConfiguration</a>
 */
public class IfcStructuralLoadConfiguration extends IfcStructuralLoad {
    protected Collection<IfcStructuralLoadOrResult> values;
    protected Collection<Collection<IfcLengthMeasure>> locations;

    protected IfcStructuralLoadConfiguration() { initCollections(); }
    /**
     * Constructs IfcStructuralLoadConfiguration with all required attributes.
     */
    public IfcStructuralLoadConfiguration(Collection<IfcStructuralLoadOrResult> values) {

        super();
        this.locations = new ArrayList<>();
        this.values = values;
    }
    /**
     * Constructs IfcStructuralLoadConfiguration with required and optional attributes.
     */
    public IfcStructuralLoadConfiguration(IfcLabel name,Collection<IfcStructuralLoadOrResult> values,Collection<Collection<IfcLengthMeasure>> locations) {
        super(name);
        this.values = values;
        this.locations = locations;
    }
    private void initCollections() {
        this.values = new ArrayList<>();
        this.locations = new ArrayList<>();
    }
    public Collection<IfcStructuralLoadOrResult> getValues() { return this.values; }
    public void setValues(Collection<IfcStructuralLoadOrResult> value) { this.values = value; }
    public Collection<Collection<IfcLengthMeasure>> getLocations() { return this.locations; }
    public void setLocations(Collection<Collection<IfcLengthMeasure>> value) { this.locations = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(values != null ? StepUtils.toStepValue(values) : "$");
		parameters.add(locations != null ? StepUtils.toStepValue(locations) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}