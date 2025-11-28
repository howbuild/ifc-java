package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCoordinateReferenceSystem
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcProjectedCRS));
 * Name : IfcLabel;
 * Description : OPTIONAL IfcText;
 * GeodeticDatum : OPTIONAL IfcIdentifier;
 * VerticalDatum : OPTIONAL IfcIdentifier;
 * INVERSE
 * HasCoordinateOperation : SET [0:1] OF IfcCoordinateOperation FOR SourceCRS;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcprojectedcrs.htm">IfcProjectedCRS</a>
 */
public class IfcProjectedCRS extends IfcCoordinateReferenceSystem {
    protected IfcIdentifier mapProjection;
    protected IfcIdentifier mapZone;
    protected IfcNamedUnit mapUnit;

    protected IfcProjectedCRS() { initCollections(); }
    /**
     * Constructs IfcProjectedCRS with all required attributes.
     */
    public IfcProjectedCRS(IfcLabel name) {

        super(name);
    }
    /**
     * Constructs IfcProjectedCRS with required and optional attributes.
     */
    public IfcProjectedCRS(IfcLabel name,IfcText description,IfcIdentifier geodeticDatum,IfcIdentifier verticalDatum,IfcIdentifier mapProjection,IfcIdentifier mapZone,IfcNamedUnit mapUnit) {
        super(name,description,geodeticDatum,verticalDatum);
        this.mapProjection = mapProjection;
        this.mapZone = mapZone;
        this.mapUnit = mapUnit;
    }
    private void initCollections() {
    }
    public IfcIdentifier getMapProjection() { return this.mapProjection; }
    public void setMapProjection(IfcIdentifier value) { this.mapProjection = value; } // optional
    public IfcIdentifier getMapZone() { return this.mapZone; }
    public void setMapZone(IfcIdentifier value) { this.mapZone = value; } // optional
    public IfcNamedUnit getMapUnit() { return this.mapUnit; }
    public void setMapUnit(IfcNamedUnit value) { this.mapUnit = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(geodeticDatum != null ? StepUtils.toStepValue(geodeticDatum) : "$");
		parameters.add(verticalDatum != null ? StepUtils.toStepValue(verticalDatum) : "$");
		parameters.add(mapProjection != null ? StepUtils.toStepValue(mapProjection) : "$");
		parameters.add(mapZone != null ? StepUtils.toStepValue(mapZone) : "$");
		parameters.add(mapUnit != null ? StepUtils.toStepValue(mapUnit) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}