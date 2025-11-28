package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFace
 * SUPERTYPE OF (ONEOF
 * (IfcFaceSurface))
 * SUBTYPE OF (IfcTopologicalRepresentationItem);
 * Bounds : SET [1:?] OF IfcFaceBound;
 * INVERSE
 * HasTextureMaps : SET [0:?] OF IfcTextureMap FOR MappedTo;
 * WHERE
 * HasOuterBound : SIZEOF(QUERY(temp <* Bounds | 'IFC4.IFCFACEOUTERBOUND' IN TYPEOF(temp))) <= 1;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcface.htm">IfcFace</a>
 */
public class IfcFace extends IfcTopologicalRepresentationItem {
    protected Collection<IfcFaceBound> bounds;
    protected Collection<IfcTextureMap> hasTextureMaps;

    protected IfcFace() { initCollections(); }
    /**
     * Constructs IfcFace with all required attributes.
     */
    public IfcFace(Collection<IfcFaceBound> bounds) {
        super();
        this.hasTextureMaps = new ArrayList<>();
        this.bounds = bounds;
    }
    private void initCollections() {
        this.bounds = new ArrayList<>();
        this.hasTextureMaps = new ArrayList<>();
    }
    public Collection<IfcFaceBound> getBounds() { return this.bounds; }
    public void setBounds(Collection<IfcFaceBound> value) { this.bounds = value; }
    public Collection<IfcTextureMap> getHasTextureMaps() { return this.hasTextureMaps; }
    public void setHasTextureMaps(Collection<IfcTextureMap> value) { this.hasTextureMaps = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(bounds != null ? StepUtils.toStepValue(bounds) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}