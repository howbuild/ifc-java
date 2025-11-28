package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPixelTexture
 * SUBTYPE OF (IfcSurfaceTexture);
 * Width : IfcInteger;
 * Height : IfcInteger;
 * ColourComponents : IfcInteger;
 * Pixel : LIST [1:?] OF IfcBinary;
 * WHERE
 * MinPixelInS : Width >= 1;
 * MinPixelInT : Height >= 1;
 * NumberOfColours : {1 <= ColourComponents <= 4};
 * SizeOfPixelList : SIZEOF(Pixel) = (Width * Height);
 * PixelAsByteAndSameLength : SIZEOF(QUERY(temp<* Pixel |
 * (BLENGTH(temp) MOD 8 = 0) AND
 * (BLENGTH(temp) = BLENGTH(Pixel[1]))
 * )) = SIZEOF(Pixel);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpixeltexture.htm">IfcPixelTexture</a>
 */
public class IfcPixelTexture extends IfcSurfaceTexture {
    protected IfcInteger width;
    protected IfcInteger height;
    protected IfcInteger colourComponents;
    protected Collection<IfcBinary> pixel;

    protected IfcPixelTexture() { initCollections(); }
    /**
     * Constructs IfcPixelTexture with all required attributes.
     */
    public IfcPixelTexture(IfcBoolean repeatS,IfcBoolean repeatT,IfcInteger width,IfcInteger height,IfcInteger colourComponents,Collection<IfcBinary> pixel) {

        super(repeatS,repeatT);
        this.width = width;
        this.height = height;
        this.colourComponents = colourComponents;
        this.pixel = pixel;
    }
    /**
     * Constructs IfcPixelTexture with required and optional attributes.
     */
    public IfcPixelTexture(IfcBoolean repeatS,IfcBoolean repeatT,IfcIdentifier mode,IfcCartesianTransformationOperator2D textureTransform,Collection<IfcIdentifier> parameter,IfcInteger width,IfcInteger height,IfcInteger colourComponents,Collection<IfcBinary> pixel) {
        super(repeatS,repeatT,mode,textureTransform,parameter);
        this.width = width;
        this.height = height;
        this.colourComponents = colourComponents;
        this.pixel = pixel;
    }
    private void initCollections() {
        this.pixel = new ArrayList<>();
    }
    public IfcInteger getWidth() { return this.width; }
    public void setWidth(IfcInteger value) { this.width = value; }
    public IfcInteger getHeight() { return this.height; }
    public void setHeight(IfcInteger value) { this.height = value; }
    public IfcInteger getColourComponents() { return this.colourComponents; }
    public void setColourComponents(IfcInteger value) { this.colourComponents = value; }
    public Collection<IfcBinary> getPixel() { return this.pixel; }
    public void setPixel(Collection<IfcBinary> value) { this.pixel = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(repeatS != null ? StepUtils.toStepValue(repeatS) : "$");
		parameters.add(repeatT != null ? StepUtils.toStepValue(repeatT) : "$");
		parameters.add(mode != null ? StepUtils.toStepValue(mode) : "$");
		parameters.add(textureTransform != null ? StepUtils.toStepValue(textureTransform) : "$");
		parameters.add(parameter != null ? StepUtils.toStepValue(parameter) : "$");
		parameters.add(width != null ? StepUtils.toStepValue(width) : "$");
		parameters.add(height != null ? StepUtils.toStepValue(height) : "$");
		parameters.add(colourComponents != null ? StepUtils.toStepValue(colourComponents) : "$");
		parameters.add(pixel != null ? StepUtils.toStepValue(pixel) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}