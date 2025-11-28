package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcTableRow;
 * RowCells : OPTIONAL LIST [1:?] OF IfcValue;
 * IsHeading : OPTIONAL IfcBoolean;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctablerow.htm">IfcTableRow</a>
 */
public class IfcTableRow extends BaseIfc {
    protected Collection<IfcValue> rowCells;
    protected IfcBoolean isHeading;


    /**
     * Constructs IfcTableRow with all required attributes.
     */
    public IfcTableRow() {

        super();
        this.rowCells = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcTableRow with required and optional attributes.
     */
    public IfcTableRow(Collection<IfcValue> rowCells,IfcBoolean isHeading) {
        super();
        this.rowCells = rowCells;
        this.isHeading = isHeading;
    }
    private void initCollections() {
        this.rowCells = new ArrayList<>();
    }
    public Collection<IfcValue> getRowCells() { return this.rowCells; }
    public void setRowCells(Collection<IfcValue> value) { this.rowCells = value; } // optional
    public IfcBoolean getIsHeading() { return this.isHeading; }
    public void setIsHeading(IfcBoolean value) { this.isHeading = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(rowCells != null ? StepUtils.toStepValue(rowCells) : "$");
		parameters.add(isHeading != null ? StepUtils.toStepValue(isHeading) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}