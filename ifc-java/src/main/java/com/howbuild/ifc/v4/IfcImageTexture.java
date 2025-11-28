package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcImageTexture
 * SUBTYPE OF (IfcSurfaceTexture);
 * URLReference : IfcURIReference;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcimagetexture.htm">IfcImageTexture</a>
 */
public class IfcImageTexture extends IfcSurfaceTexture {
    protected IfcURIReference uRLReference;

    protected IfcImageTexture() { initCollections(); }
    /**
     * Constructs IfcImageTexture with all required attributes.
     */
    public IfcImageTexture(IfcBoolean repeatS,IfcBoolean repeatT,IfcURIReference uRLReference) {

        super(repeatS,repeatT);
        this.uRLReference = uRLReference;
    }
    /**
     * Constructs IfcImageTexture with required and optional attributes.
     */
    public IfcImageTexture(IfcBoolean repeatS,IfcBoolean repeatT,IfcIdentifier mode,IfcCartesianTransformationOperator2D textureTransform,Collection<IfcIdentifier> parameter,IfcURIReference uRLReference) {
        super(repeatS,repeatT,mode,textureTransform,parameter);
        this.uRLReference = uRLReference;
    }
    private void initCollections() {
    }
    public IfcURIReference getURLReference() { return this.uRLReference; }
    public void setURLReference(IfcURIReference value) { this.uRLReference = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(repeatS != null ? StepUtils.toStepValue(repeatS) : "$");
		parameters.add(repeatT != null ? StepUtils.toStepValue(repeatT) : "$");
		parameters.add(mode != null ? StepUtils.toStepValue(mode) : "$");
		parameters.add(textureTransform != null ? StepUtils.toStepValue(textureTransform) : "$");
		parameters.add(parameter != null ? StepUtils.toStepValue(parameter) : "$");
		parameters.add(uRLReference != null ? StepUtils.toStepValue(uRLReference) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}