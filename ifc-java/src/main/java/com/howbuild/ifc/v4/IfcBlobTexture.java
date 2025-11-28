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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcblobtexture.htm">IfcBlobTexture</a>
 */
public class IfcBlobTexture extends IfcSurfaceTexture {
    protected IfcIdentifier rasterFormat;
    protected IfcBinary rasterCode;

    protected IfcBlobTexture() { initCollections(); }
    /**
     * Constructs IfcBlobTexture with all required attributes.
     */
    public IfcBlobTexture(IfcBoolean repeatS,IfcBoolean repeatT,IfcIdentifier rasterFormat,IfcBinary rasterCode) {

        super(repeatS,repeatT);
        this.rasterFormat = rasterFormat;
        this.rasterCode = rasterCode;
    }
    /**
     * Constructs IfcBlobTexture with required and optional attributes.
     */
    public IfcBlobTexture(IfcBoolean repeatS,IfcBoolean repeatT,IfcIdentifier mode,IfcCartesianTransformationOperator2D textureTransform,Collection<IfcIdentifier> parameter,IfcIdentifier rasterFormat,IfcBinary rasterCode) {
        super(repeatS,repeatT,mode,textureTransform,parameter);
        this.rasterFormat = rasterFormat;
        this.rasterCode = rasterCode;
    }
    private void initCollections() {
    }
    public IfcIdentifier getRasterFormat() { return this.rasterFormat; }
    public void setRasterFormat(IfcIdentifier value) { this.rasterFormat = value; }
    public IfcBinary getRasterCode() { return this.rasterCode; }
    public void setRasterCode(IfcBinary value) { this.rasterCode = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(repeatS != null ? StepUtils.toStepValue(repeatS) : "$");
		parameters.add(repeatT != null ? StepUtils.toStepValue(repeatT) : "$");
		parameters.add(mode != null ? StepUtils.toStepValue(mode) : "$");
		parameters.add(textureTransform != null ? StepUtils.toStepValue(textureTransform) : "$");
		parameters.add(parameter != null ? StepUtils.toStepValue(parameter) : "$");
		parameters.add(rasterFormat != null ? StepUtils.toStepValue(rasterFormat) : "$");
		parameters.add(rasterCode != null ? StepUtils.toStepValue(rasterCode) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}