package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFillAreaStyleTiles
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * TilingPattern : LIST [2:2] OF IfcVector;
 * Tiles : SET [1:?] OF IfcStyledItem;
 * TilingScale : IfcPositiveRatioMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfillareastyletiles.htm">IfcFillAreaStyleTiles</a>
 */
public class IfcFillAreaStyleTiles extends IfcGeometricRepresentationItem implements IfcFillStyleSelect {
    protected Collection<IfcVector> tilingPattern;
    protected Collection<IfcStyledItem> tiles;
    protected IfcPositiveRatioMeasure tilingScale;

    protected IfcFillAreaStyleTiles() { initCollections(); }
    /**
     * Constructs IfcFillAreaStyleTiles with all required attributes.
     */
    public IfcFillAreaStyleTiles(Collection<IfcVector> tilingPattern,Collection<IfcStyledItem> tiles,IfcPositiveRatioMeasure tilingScale) {
        super();
        this.tilingPattern = tilingPattern;
        this.tiles = tiles;
        this.tilingScale = tilingScale;
    }
    private void initCollections() {
        this.tilingPattern = new ArrayList<>();
        this.tiles = new ArrayList<>();
    }
    public Collection<IfcVector> getTilingPattern() { return this.tilingPattern; }
    public void setTilingPattern(Collection<IfcVector> value) { this.tilingPattern = value; }
    public Collection<IfcStyledItem> getTiles() { return this.tiles; }
    public void setTiles(Collection<IfcStyledItem> value) { this.tiles = value; }
    public IfcPositiveRatioMeasure getTilingScale() { return this.tilingScale; }
    public void setTilingScale(IfcPositiveRatioMeasure value) { this.tilingScale = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(tilingPattern != null ? StepUtils.toStepValue(tilingPattern) : "$");
		parameters.add(tiles != null ? StepUtils.toStepValue(tiles) : "$");
		parameters.add(tilingScale != null ? StepUtils.toStepValue(tilingScale) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}