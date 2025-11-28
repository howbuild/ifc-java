package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcTable;
 * Name : OPTIONAL IfcLabel;
 * Rows : OPTIONAL LIST [1:?] OF IfcTableRow;
 * Columns : OPTIONAL LIST [1:?] OF IfcTableColumn;
 * DERIVE
 * NumberOfCellsInRow : IfcInteger := HIINDEX(Rows[1].RowCells);
 * NumberOfHeadings : IfcInteger := SIZEOF(QUERY( Temp <* Rows | Temp.IsHeading));
 * NumberOfDataRows : IfcInteger := SIZEOF(QUERY( Temp <* Rows | NOT(Temp.IsHeading)));
 * WHERE
 * WR1 : SIZEOF(QUERY( Temp <* Rows | HIINDEX(Temp.RowCells) <> HIINDEX(Rows[1].RowCells))) = 0;
 * WR2 : { 0 <= NumberOfHeadings <= 1 };
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctable.htm">IfcTable</a>
 */
public class IfcTable extends BaseIfc implements IfcMetricValueSelect, IfcObjectReferenceSelect {
    protected IfcLabel name;
    protected Collection<IfcTableRow> rows;
    protected Collection<IfcTableColumn> columns;


    /**
     * Constructs IfcTable with all required attributes.
     */
    public IfcTable() {

        super();
        this.rows = new ArrayList<>();
        this.columns = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcTable with required and optional attributes.
     */
    public IfcTable(IfcLabel name,Collection<IfcTableRow> rows,Collection<IfcTableColumn> columns) {
        super();
        this.name = name;
        this.rows = rows;
        this.columns = columns;
    }
    private void initCollections() {
        this.rows = new ArrayList<>();
        this.columns = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public Collection<IfcTableRow> getRows() { return this.rows; }
    public void setRows(Collection<IfcTableRow> value) { this.rows = value; } // optional
    public Collection<IfcTableColumn> getColumns() { return this.columns; }
    public void setColumns(Collection<IfcTableColumn> value) { this.columns = value; } // optional
    public IfcInteger getNumberOfCellsInRow() { throw new UnsupportedOperationException("Derived property logic has been implemented for NumberOfCellsInRow."); } // derived
    public IfcInteger getNumberOfHeadings() { throw new UnsupportedOperationException("Derived property logic has been implemented for NumberOfHeadings."); } // derived
    public IfcInteger getNumberOfDataRows() { throw new UnsupportedOperationException("Derived property logic has been implemented for NumberOfDataRows."); } // derived

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(rows != null ? StepUtils.toStepValue(rows) : "$");
		parameters.add(columns != null ? StepUtils.toStepValue(columns) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}