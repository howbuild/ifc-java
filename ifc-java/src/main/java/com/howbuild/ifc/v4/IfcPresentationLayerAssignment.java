package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPresentationLayerAssignment
 * SUPERTYPE OF (ONEOF
 * (IfcPresentationLayerWithStyle));
 * Name : IfcLabel;
 * Description : OPTIONAL IfcText;
 * AssignedItems : SET [1:?] OF IfcLayeredItem;
 * Identifier : OPTIONAL IfcIdentifier;
 * WHERE
 * ApplicableItems : SIZEOF(QUERY(temp <* AssignedItems | (
 * SIZEOF(TYPEOF(temp) * [
 * 'IFC4.IFCSHAPEREPRESENTATION',
 * 'IFC4.IFCGEOMETRICREPRESENTATIONITEM',
 * 'IFC4.IFCMAPPEDITEM']) = 1)
 * )) = SIZEOF(AssignedItems);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpresentationlayerassignment.htm">IfcPresentationLayerAssignment</a>
 */
public class IfcPresentationLayerAssignment extends BaseIfc {
    protected IfcLabel name;
    protected IfcText description;
    protected Collection<IfcLayeredItem> assignedItems;
    protected IfcIdentifier identifier;

    protected IfcPresentationLayerAssignment() { initCollections(); }
    /**
     * Constructs IfcPresentationLayerAssignment with all required attributes.
     */
    public IfcPresentationLayerAssignment(IfcLabel name,Collection<IfcLayeredItem> assignedItems) {

        super();
        this.name = name;
        this.assignedItems = assignedItems;
    }
    /**
     * Constructs IfcPresentationLayerAssignment with required and optional attributes.
     */
    public IfcPresentationLayerAssignment(IfcLabel name,IfcText description,Collection<IfcLayeredItem> assignedItems,IfcIdentifier identifier) {
        super();
        this.name = name;
        this.description = description;
        this.assignedItems = assignedItems;
        this.identifier = identifier;
    }
    private void initCollections() {
        this.assignedItems = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; }
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public Collection<IfcLayeredItem> getAssignedItems() { return this.assignedItems; }
    public void setAssignedItems(Collection<IfcLayeredItem> value) { this.assignedItems = value; }
    public IfcIdentifier getIdentifier() { return this.identifier; }
    public void setIdentifier(IfcIdentifier value) { this.identifier = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(assignedItems != null ? StepUtils.toStepValue(assignedItems) : "$");
		parameters.add(identifier != null ? StepUtils.toStepValue(identifier) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcPresentationLayerAssignmentRelationship(); }
    private void setIfcPresentationLayerAssignmentRelationship() {
		if (this.assignedItems != null) {
		    for (Object x : this.assignedItems) {
		        if (x instanceof IfcRepresentation)
		            ((IfcRepresentation)x).layerAssignments.add(this);
		    }
		}
		if (this.assignedItems != null) {
		    for (Object x : this.assignedItems) {
		        if (x instanceof IfcRepresentationItem)
		            ((IfcRepresentationItem)x).layerAssignment.add(this);
		    }
		}
    }
}