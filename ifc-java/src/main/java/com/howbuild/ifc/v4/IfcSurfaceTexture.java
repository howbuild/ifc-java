package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcBlobTexture
 * SUBTYPE OF (IfcSurfaceTexture);
 * RasterFormat : IfcIdentifier;
 * RasterCode : IfcBinary;
 * WHERE
 * SupportedRasterFormat : SELF.RasterFormat IN ['BMP', 'JPG', 'GIF', 'PNG'];
 * RasterCodeByteStream : BLENGTH(RasterCode) MOD 8 = 0;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurfacetexture.htm">IfcSurfaceTexture</a>
 */
public abstract class IfcSurfaceTexture extends IfcPresentationItem {
    protected IfcBoolean repeatS;
    protected IfcBoolean repeatT;
    protected IfcIdentifier mode;
    protected IfcCartesianTransformationOperator2D textureTransform;
    protected Collection<IfcIdentifier> parameter;
    protected Collection<IfcTextureCoordinate> isMappedBy;
    protected Collection<IfcSurfaceStyleWithTextures> usedInStyles;

    protected IfcSurfaceTexture() { initCollections(); }
    /**
     * Constructs IfcSurfaceTexture with all required attributes.
     */
    public IfcSurfaceTexture(IfcBoolean repeatS,IfcBoolean repeatT) {

        super();
        this.parameter = new ArrayList<>();
        this.isMappedBy = new ArrayList<>();
        this.usedInStyles = new ArrayList<>();
        this.repeatS = repeatS;
        this.repeatT = repeatT;
    }
    /**
     * Constructs IfcSurfaceTexture with required and optional attributes.
     */
    public IfcSurfaceTexture(IfcBoolean repeatS,IfcBoolean repeatT,IfcIdentifier mode,IfcCartesianTransformationOperator2D textureTransform,Collection<IfcIdentifier> parameter) {
        super();
        this.isMappedBy = new ArrayList<>();
        this.usedInStyles = new ArrayList<>();
        this.repeatS = repeatS;
        this.repeatT = repeatT;
        this.mode = mode;
        this.textureTransform = textureTransform;
        this.parameter = parameter;
    }
    private void initCollections() {
        this.parameter = new ArrayList<>();
        this.isMappedBy = new ArrayList<>();
        this.usedInStyles = new ArrayList<>();
    }
    public IfcBoolean getRepeatS() { return this.repeatS; }
    public void setRepeatS(IfcBoolean value) { this.repeatS = value; }
    public IfcBoolean getRepeatT() { return this.repeatT; }
    public void setRepeatT(IfcBoolean value) { this.repeatT = value; }
    public IfcIdentifier getMode() { return this.mode; }
    public void setMode(IfcIdentifier value) { this.mode = value; } // optional
    public IfcCartesianTransformationOperator2D getTextureTransform() { return this.textureTransform; }
    public void setTextureTransform(IfcCartesianTransformationOperator2D value) { this.textureTransform = value; } // optional
    public Collection<IfcIdentifier> getParameter() { return this.parameter; }
    public void setParameter(Collection<IfcIdentifier> value) { this.parameter = value; } // optional
    public Collection<IfcTextureCoordinate> getIsMappedBy() { return this.isMappedBy; }
    public void setIsMappedBy(Collection<IfcTextureCoordinate> value) { this.isMappedBy = value; } // inverse
    public Collection<IfcSurfaceStyleWithTextures> getUsedInStyles() { return this.usedInStyles; }
    public void setUsedInStyles(Collection<IfcSurfaceStyleWithTextures> value) { this.usedInStyles = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}