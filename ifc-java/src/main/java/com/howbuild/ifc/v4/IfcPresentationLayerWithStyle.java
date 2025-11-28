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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpresentationlayerwithstyle.htm">IfcPresentationLayerWithStyle</a>
 */
public class IfcPresentationLayerWithStyle extends IfcPresentationLayerAssignment {
    protected IfcLogical layerOn;
    protected IfcLogical layerFrozen;
    protected IfcLogical layerBlocked;
    protected Collection<IfcPresentationStyle> layerStyles;

    protected IfcPresentationLayerWithStyle() { initCollections(); }
    /**
     * Constructs IfcPresentationLayerWithStyle with all required attributes.
     */
    public IfcPresentationLayerWithStyle(IfcLabel name,Collection<IfcLayeredItem> assignedItems,IfcLogical layerOn,IfcLogical layerFrozen,IfcLogical layerBlocked,Collection<IfcPresentationStyle> layerStyles) {

        super(name,assignedItems);
        this.layerOn = layerOn;
        this.layerFrozen = layerFrozen;
        this.layerBlocked = layerBlocked;
        this.layerStyles = layerStyles;
    }
    /**
     * Constructs IfcPresentationLayerWithStyle with required and optional attributes.
     */
    public IfcPresentationLayerWithStyle(IfcLabel name,IfcText description,Collection<IfcLayeredItem> assignedItems,IfcIdentifier identifier,IfcLogical layerOn,IfcLogical layerFrozen,IfcLogical layerBlocked,Collection<IfcPresentationStyle> layerStyles) {
        super(name,description,assignedItems,identifier);
        this.layerOn = layerOn;
        this.layerFrozen = layerFrozen;
        this.layerBlocked = layerBlocked;
        this.layerStyles = layerStyles;
    }
    private void initCollections() {
        this.layerStyles = new ArrayList<>();
    }
    public IfcLogical getLayerOn() { return this.layerOn; }
    public void setLayerOn(IfcLogical value) { this.layerOn = value; }
    public IfcLogical getLayerFrozen() { return this.layerFrozen; }
    public void setLayerFrozen(IfcLogical value) { this.layerFrozen = value; }
    public IfcLogical getLayerBlocked() { return this.layerBlocked; }
    public void setLayerBlocked(IfcLogical value) { this.layerBlocked = value; }
    public Collection<IfcPresentationStyle> getLayerStyles() { return this.layerStyles; }
    public void setLayerStyles(Collection<IfcPresentationStyle> value) { this.layerStyles = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(assignedItems != null ? StepUtils.toStepValue(assignedItems) : "$");
		parameters.add(identifier != null ? StepUtils.toStepValue(identifier) : "$");
		parameters.add(layerOn != null ? StepUtils.toStepValue(layerOn) : "$");
		parameters.add(layerFrozen != null ? StepUtils.toStepValue(layerFrozen) : "$");
		parameters.add(layerBlocked != null ? StepUtils.toStepValue(layerBlocked) : "$");
		parameters.add(layerStyles != null ? StepUtils.toStepValue(layerStyles) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}