package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterialLayerSetUsage
 * SUBTYPE OF (IfcMaterialUsageDefinition);
 * ForLayerSet : IfcMaterialLayerSet;
 * LayerSetDirection : IfcLayerSetDirectionEnum;
 * DirectionSense : IfcDirectionSenseEnum;
 * OffsetFromReferenceLine : IfcLengthMeasure;
 * ReferenceExtent : OPTIONAL IfcPositiveLengthMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmaterialusagedefinition.htm">IfcMaterialUsageDefinition</a>
 */
public abstract class IfcMaterialUsageDefinition extends BaseIfc implements IfcMaterialSelect {
    protected Collection<IfcRelAssociatesMaterial> associatedTo;


    /**
     * Constructs IfcMaterialUsageDefinition with all required attributes.
     */
    public IfcMaterialUsageDefinition() {
        super();
        this.associatedTo = new ArrayList<>();
        initCollections();
    }
    private void initCollections() {
        this.associatedTo = new ArrayList<>();
    }
    public Collection<IfcRelAssociatesMaterial> getAssociatedTo() { return this.associatedTo; }
    public void setAssociatedTo(Collection<IfcRelAssociatesMaterial> value) { this.associatedTo = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}