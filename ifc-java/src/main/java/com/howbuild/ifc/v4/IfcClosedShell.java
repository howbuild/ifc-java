package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcClosedShell
 * SUBTYPE OF (IfcConnectedFaceSet);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcclosedshell.htm">IfcClosedShell</a>
 */
public class IfcClosedShell extends IfcConnectedFaceSet implements IfcShell, IfcSolidOrShell {

    protected IfcClosedShell() { initCollections(); }
    /**
     * Constructs IfcClosedShell with all required attributes.
     */
    public IfcClosedShell(Collection<IfcFace> cfsFaces) {
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