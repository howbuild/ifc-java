package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcTextureCoordinate
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcIndexedTextureMap
 * ,IfcTextureCoordinateGenerator
 * ,IfcTextureMap))
 * SUBTYPE OF (IfcPresentationItem);
 * Maps : LIST [1:?] OF IfcSurfaceTexture;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctexturecoordinategenerator.htm">IfcTextureCoordinateGenerator</a>
 */
public class IfcTextureCoordinateGenerator extends IfcTextureCoordinate {
    protected IfcLabel mode;
    protected Collection<IfcReal> parameter;

    protected IfcTextureCoordinateGenerator() { initCollections(); }
    /**
     * Constructs IfcTextureCoordinateGenerator with all required attributes.
     */
    public IfcTextureCoordinateGenerator(Collection<IfcSurfaceTexture> maps,IfcLabel mode) {

        super(maps);
        this.parameter = new ArrayList<>();
        this.mode = mode;
    }
    /**
     * Constructs IfcTextureCoordinateGenerator with required and optional attributes.
     */
    public IfcTextureCoordinateGenerator(Collection<IfcSurfaceTexture> maps,IfcLabel mode,Collection<IfcReal> parameter) {
        super(maps);
        this.mode = mode;
        this.parameter = parameter;
    }
    private void initCollections() {
        this.parameter = new ArrayList<>();
    }
    public IfcLabel getMode() { return this.mode; }
    public void setMode(IfcLabel value) { this.mode = value; }
    public Collection<IfcReal> getParameter() { return this.parameter; }
    public void setParameter(Collection<IfcReal> value) { this.parameter = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(maps != null ? StepUtils.toStepValue(maps) : "$");
		parameters.add(mode != null ? StepUtils.toStepValue(mode) : "$");
		parameters.add(parameter != null ? StepUtils.toStepValue(parameter) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}