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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcconnectedfaceset.htm">IfcConnectedFaceSet</a>
 */
public class IfcConnectedFaceSet extends IfcTopologicalRepresentationItem {
    protected Collection<IfcFace> cfsFaces;

    protected IfcConnectedFaceSet() { initCollections(); }
    /**
     * Constructs IfcConnectedFaceSet with all required attributes.
     */
    public IfcConnectedFaceSet(Collection<IfcFace> cfsFaces) {
        super();
        this.cfsFaces = cfsFaces;
    }
    private void initCollections() {
        this.cfsFaces = new ArrayList<>();
    }
    public Collection<IfcFace> getCfsFaces() { return this.cfsFaces; }
    public void setCfsFaces(Collection<IfcFace> value) { this.cfsFaces = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(cfsFaces != null ? StepUtils.toStepValue(cfsFaces) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}