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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccoordinatereferencesystem.htm">IfcCoordinateReferenceSystem</a>
 */
public abstract class IfcCoordinateReferenceSystem extends BaseIfc implements IfcCoordinateReferenceSystemSelect {
    protected IfcLabel name;
    protected IfcText description;
    protected IfcIdentifier geodeticDatum;
    protected IfcIdentifier verticalDatum;
    protected Collection<IfcCoordinateOperation> hasCoordinateOperation;

    protected IfcCoordinateReferenceSystem() { initCollections(); }
    /**
     * Constructs IfcCoordinateReferenceSystem with all required attributes.
     */
    public IfcCoordinateReferenceSystem(IfcLabel name) {

        super();
        this.hasCoordinateOperation = new ArrayList<>();
        this.name = name;
    }
    /**
     * Constructs IfcCoordinateReferenceSystem with required and optional attributes.
     */
    public IfcCoordinateReferenceSystem(IfcLabel name,IfcText description,IfcIdentifier geodeticDatum,IfcIdentifier verticalDatum) {
        super();
        this.hasCoordinateOperation = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.geodeticDatum = geodeticDatum;
        this.verticalDatum = verticalDatum;
    }
    private void initCollections() {
        this.hasCoordinateOperation = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; }
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcIdentifier getGeodeticDatum() { return this.geodeticDatum; }
    public void setGeodeticDatum(IfcIdentifier value) { this.geodeticDatum = value; } // optional
    public IfcIdentifier getVerticalDatum() { return this.verticalDatum; }
    public void setVerticalDatum(IfcIdentifier value) { this.verticalDatum = value; } // optional
    public Collection<IfcCoordinateOperation> getHasCoordinateOperation() { return this.hasCoordinateOperation; }
    public void setHasCoordinateOperation(Collection<IfcCoordinateOperation> value) { this.hasCoordinateOperation = value; } // inverse


    // inherits no-op finalizeRelationships from BaseIfc

}