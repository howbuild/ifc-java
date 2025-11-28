package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcPresentationStyle
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcCurveStyle
 * ,IfcFillAreaStyle
 * ,IfcSurfaceStyle
 * ,IfcTextStyle));
 * Name : OPTIONAL IfcLabel;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsurfacestyle.htm">IfcSurfaceStyle</a>
 */
public class IfcSurfaceStyle extends IfcPresentationStyle implements IfcPresentationStyleSelect {
    protected IfcSurfaceSide side;
    protected Collection<IfcSurfaceStyleElementSelect> styles;

    protected IfcSurfaceStyle() { initCollections(); }
    /**
     * Constructs IfcSurfaceStyle with all required attributes.
     */
    public IfcSurfaceStyle(IfcSurfaceSide side,Collection<IfcSurfaceStyleElementSelect> styles) {

        super();
        this.side = side;
        this.styles = styles;
    }
    /**
     * Constructs IfcSurfaceStyle with required and optional attributes.
     */
    public IfcSurfaceStyle(IfcLabel name,IfcSurfaceSide side,Collection<IfcSurfaceStyleElementSelect> styles) {
        super(name);
        this.side = side;
        this.styles = styles;
    }
    private void initCollections() {
        this.styles = new ArrayList<>();
    }
    public IfcSurfaceSide getSide() { return this.side; }
    public void setSide(IfcSurfaceSide value) { this.side = value; }
    public Collection<IfcSurfaceStyleElementSelect> getStyles() { return this.styles; }
    public void setStyles(Collection<IfcSurfaceStyleElementSelect> value) { this.styles = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(side != null ? StepUtils.toStepValue(side) : "$");
		parameters.add(styles != null ? StepUtils.toStepValue(styles) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}