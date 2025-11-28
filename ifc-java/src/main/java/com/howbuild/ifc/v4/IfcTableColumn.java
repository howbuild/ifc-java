package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcTableColumn;
 * Identifier : OPTIONAL IfcIdentifier;
 * Name : OPTIONAL IfcLabel;
 * Description : OPTIONAL IfcText;
 * Unit : OPTIONAL IfcUnit;
 * ReferencePath : OPTIONAL IfcReference;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctablecolumn.htm">IfcTableColumn</a>
 */
public class IfcTableColumn extends BaseIfc {
    protected IfcIdentifier identifier;
    protected IfcLabel name;
    protected IfcText description;
    protected IfcUnit unit;
    protected IfcReference referencePath;


    /**
     * Constructs IfcTableColumn with all required attributes.
     */
    public IfcTableColumn() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcTableColumn with required and optional attributes.
     */
    public IfcTableColumn(IfcIdentifier identifier,IfcLabel name,IfcText description,IfcUnit unit,IfcReference referencePath) {
        super();
        this.identifier = identifier;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.referencePath = referencePath;
    }
    private void initCollections() {
    }
    public IfcIdentifier getIdentifier() { return this.identifier; }
    public void setIdentifier(IfcIdentifier value) { this.identifier = value; } // optional
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcUnit getUnit() { return this.unit; }
    public void setUnit(IfcUnit value) { this.unit = value; } // optional
    public IfcReference getReferencePath() { return this.referencePath; }
    public void setReferencePath(IfcReference value) { this.referencePath = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(identifier != null ? StepUtils.toStepValue(identifier) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(unit != null ? StepUtils.toStepValue(unit) : "$");
		parameters.add(referencePath != null ? StepUtils.toStepValue(referencePath) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}