package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcConnectedFaceSet
 * SUPERTYPE OF (ONEOF
 * (IfcClosedShell
 * ,IfcOpenShell))
 * SUBTYPE OF (IfcTopologicalRepresentationItem);
 * CfsFaces : SET [1:?] OF IfcFace;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcopenshell.htm">IfcOpenShell</a>
 */
public class IfcOpenShell extends IfcConnectedFaceSet implements IfcShell {

    protected IfcOpenShell() { initCollections(); }
    /**
     * Constructs IfcOpenShell with all required attributes.
     */
    public IfcOpenShell(Collection<IfcFace> cfsFaces) {
        super(cfsFaces);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(cfsFaces != null ? StepUtils.toStepValue(cfsFaces) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}