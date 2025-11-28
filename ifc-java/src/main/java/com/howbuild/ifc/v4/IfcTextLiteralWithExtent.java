package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcTextLiteral
 * SUPERTYPE OF (ONEOF
 * (IfcTextLiteralWithExtent))
 * SUBTYPE OF (IfcGeometricRepresentationItem);
 * Literal : IfcPresentableText;
 * Placement : IfcAxis2Placement;
 * Path : IfcTextPath;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctextliteralwithextent.htm">IfcTextLiteralWithExtent</a>
 */
public class IfcTextLiteralWithExtent extends IfcTextLiteral {
    protected IfcPlanarExtent extent;
    protected IfcBoxAlignment boxAlignment;

    protected IfcTextLiteralWithExtent() { initCollections(); }
    /**
     * Constructs IfcTextLiteralWithExtent with all required attributes.
     */
    public IfcTextLiteralWithExtent(IfcPresentableText literal,IfcAxis2Placement placement,IfcTextPath path,IfcPlanarExtent extent,IfcBoxAlignment boxAlignment) {
        super(literal,placement,path);
        this.extent = extent;
        this.boxAlignment = boxAlignment;
    }
    private void initCollections() {
    }
    public IfcPlanarExtent getExtent() { return this.extent; }
    public void setExtent(IfcPlanarExtent value) { this.extent = value; }
    public IfcBoxAlignment getBoxAlignment() { return this.boxAlignment; }
    public void setBoxAlignment(IfcBoxAlignment value) { this.boxAlignment = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(literal != null ? StepUtils.toStepValue(literal) : "$");
		parameters.add(placement != null ? StepUtils.toStepValue(placement) : "$");
		parameters.add(path != null ? StepUtils.toStepValue(path) : "$");
		parameters.add(extent != null ? StepUtils.toStepValue(extent) : "$");
		parameters.add(boxAlignment != null ? StepUtils.toStepValue(boxAlignment) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}