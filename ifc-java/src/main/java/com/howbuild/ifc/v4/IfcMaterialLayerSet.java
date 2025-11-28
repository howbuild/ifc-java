package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcMaterialDefinition
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcMaterial
 * ,IfcMaterialConstituent
 * ,IfcMaterialConstituentSet
 * ,IfcMaterialLayer
 * ,IfcMaterialLayerSet
 * ,IfcMaterialProfile
 * ,IfcMaterialProfileSet));
 * INVERSE
 * AssociatedTo : SET [0:?] OF IfcRelAssociatesMaterial FOR RelatingMaterial;
 * HasExternalReferences : SET [0:?] OF IfcExternalReferenceRelationship FOR RelatedResourceObjects;
 * HasProperties : SET [0:?] OF IfcMaterialProperties FOR Material;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcmateriallayerset.htm">IfcMaterialLayerSet</a>
 */
public class IfcMaterialLayerSet extends IfcMaterialDefinition {
    protected Collection<IfcMaterialLayer> materialLayers;
    protected IfcLabel layerSetName;
    protected IfcText description;

    protected IfcMaterialLayerSet() { initCollections(); }
    /**
     * Constructs IfcMaterialLayerSet with all required attributes.
     */
    public IfcMaterialLayerSet(Collection<IfcMaterialLayer> materialLayers) {

        super();
        this.materialLayers = materialLayers;
    }
    /**
     * Constructs IfcMaterialLayerSet with required and optional attributes.
     */
    public IfcMaterialLayerSet(Collection<IfcMaterialLayer> materialLayers,IfcLabel layerSetName,IfcText description) {
        super();
        this.materialLayers = materialLayers;
        this.layerSetName = layerSetName;
        this.description = description;
    }
    private void initCollections() {
        this.materialLayers = new ArrayList<>();
    }
    public Collection<IfcMaterialLayer> getMaterialLayers() { return this.materialLayers; }
    public void setMaterialLayers(Collection<IfcMaterialLayer> value) { this.materialLayers = value; }
    public IfcLabel getLayerSetName() { return this.layerSetName; }
    public void setLayerSetName(IfcLabel value) { this.layerSetName = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcLengthMeasure getTotalThickness() { throw new UnsupportedOperationException("Derived property logic has been implemented for TotalThickness."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(materialLayers != null ? StepUtils.toStepValue(materialLayers) : "$");
		parameters.add(layerSetName != null ? StepUtils.toStepValue(layerSetName) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcMaterialLayerSetRelationship(); }
    private void setIfcMaterialLayerSetRelationship() {
		if (this.materialLayers != null) {
		    for (Object x : this.materialLayers) {
		        if (x instanceof IfcMaterialLayer)
		            ((IfcMaterialLayer)x).toMaterialLayerSet = this;
		    }
		}
    }
}