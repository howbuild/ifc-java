package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPresentationStyleAssignment;
 * Styles : SET [1:?] OF IfcPresentationStyleSelect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpresentationstyleassignment.htm">IfcPresentationStyleAssignment</a>
 */
public class IfcPresentationStyleAssignment extends BaseIfc implements IfcStyleAssignmentSelect {
    protected Collection<IfcPresentationStyleSelect> styles;

    protected IfcPresentationStyleAssignment() { initCollections(); }
    /**
     * Constructs IfcPresentationStyleAssignment with all required attributes.
     */
    public IfcPresentationStyleAssignment(Collection<IfcPresentationStyleSelect> styles) {
        super();
        this.styles = styles;
    }
    private void initCollections() {
        this.styles = new ArrayList<>();
    }
    public Collection<IfcPresentationStyleSelect> getStyles() { return this.styles; }
    public void setStyles(Collection<IfcPresentationStyleSelect> value) { this.styles = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(styles != null ? StepUtils.toStepValue(styles) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}