package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRepresentationItem
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcGeometricRepresentationItem
 * ,IfcMappedItem
 * ,IfcStyledItem
 * ,IfcTopologicalRepresentationItem));
 * INVERSE
 * LayerAssignment : SET [0:1] OF IfcPresentationLayerAssignment FOR AssignedItems;
 * StyledByItem : SET [0:1] OF IfcStyledItem FOR Item;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstyleditem.htm">IfcStyledItem</a>
 */
public class IfcStyledItem extends IfcRepresentationItem {
    protected IfcRepresentationItem item;
    protected Collection<IfcStyleAssignmentSelect> styles;
    protected IfcLabel name;

    protected IfcStyledItem() { initCollections(); }
    /**
     * Constructs IfcStyledItem with all required attributes.
     */
    public IfcStyledItem(Collection<IfcStyleAssignmentSelect> styles) {

        super();
        this.styles = styles;
    }
    /**
     * Constructs IfcStyledItem with required and optional attributes.
     */
    public IfcStyledItem(IfcRepresentationItem item,Collection<IfcStyleAssignmentSelect> styles,IfcLabel name) {
        super();
        this.item = item;
        this.styles = styles;
        this.name = name;
    }
    private void initCollections() {
        this.styles = new ArrayList<>();
    }
    public IfcRepresentationItem getItem() { return this.item; }
    public void setItem(IfcRepresentationItem value) { this.item = value; } // optional
    public Collection<IfcStyleAssignmentSelect> getStyles() { return this.styles; }
    public void setStyles(Collection<IfcStyleAssignmentSelect> value) { this.styles = value; }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(item != null ? StepUtils.toStepValue(item) : "$");
		parameters.add(styles != null ? StepUtils.toStepValue(styles) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcStyledItemRelationship(); }
    private void setIfcStyledItemRelationship() {
		if (this.item != null) {
		    if (this.item instanceof IfcRepresentationItem)
		        ((IfcRepresentationItem)this.item).styledByItem.add(this);
		}
    }
}