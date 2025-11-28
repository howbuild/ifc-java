package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCoordinateOperation
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcMapConversion));
 * SourceCRS : IfcCoordinateReferenceSystemSelect;
 * TargetCRS : IfcCoordinateReferenceSystem;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccoordinateoperation.htm">IfcCoordinateOperation</a>
 */
public abstract class IfcCoordinateOperation extends BaseIfc {
    protected IfcCoordinateReferenceSystemSelect sourceCRS;
    protected IfcCoordinateReferenceSystem targetCRS;

    protected IfcCoordinateOperation() { initCollections(); }
    /**
     * Constructs IfcCoordinateOperation with all required attributes.
     */
    public IfcCoordinateOperation(IfcCoordinateReferenceSystemSelect sourceCRS,IfcCoordinateReferenceSystem targetCRS) {
        super();
        this.sourceCRS = sourceCRS;
        this.targetCRS = targetCRS;
    }
    private void initCollections() {
    }
    public IfcCoordinateReferenceSystemSelect getSourceCRS() { return this.sourceCRS; }
    public void setSourceCRS(IfcCoordinateReferenceSystemSelect value) { this.sourceCRS = value; }
    public IfcCoordinateReferenceSystem getTargetCRS() { return this.targetCRS; }
    public void setTargetCRS(IfcCoordinateReferenceSystem value) { this.targetCRS = value; }


    @Override public void finalizeRelationships() { this.setIfcCoordinateOperationRelationship(); }
    private void setIfcCoordinateOperationRelationship() {
		if (this.sourceCRS != null) {
		    if (this.sourceCRS instanceof IfcCoordinateReferenceSystem)
		        ((IfcCoordinateReferenceSystem)this.sourceCRS).hasCoordinateOperation.add(this);
		}
		if (this.sourceCRS != null) {
		    if (this.sourceCRS instanceof IfcGeometricRepresentationContext)
		        ((IfcGeometricRepresentationContext)this.sourceCRS).hasCoordinateOperation.add(this);
		}
    }
}