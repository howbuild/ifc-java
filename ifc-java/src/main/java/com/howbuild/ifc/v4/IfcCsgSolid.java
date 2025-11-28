package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcCsgSolid
 * SUBTYPE OF (IfcSolidModel);
 * TreeRootExpression : IfcCsgSelect;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifccsgsolid.htm">IfcCsgSolid</a>
 */
public class IfcCsgSolid extends IfcSolidModel {
    protected IfcCsgSelect treeRootExpression;

    protected IfcCsgSolid() { initCollections(); }
    /**
     * Constructs IfcCsgSolid with all required attributes.
     */
    public IfcCsgSolid(IfcCsgSelect treeRootExpression) {
        super();
        this.treeRootExpression = treeRootExpression;
    }
    private void initCollections() {
    }
    public IfcCsgSelect getTreeRootExpression() { return this.treeRootExpression; }
    public void setTreeRootExpression(IfcCsgSelect value) { this.treeRootExpression = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(treeRootExpression != null ? StepUtils.toStepValue(treeRootExpression) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}