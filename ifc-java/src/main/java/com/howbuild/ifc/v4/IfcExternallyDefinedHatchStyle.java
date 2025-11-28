package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcExternalReference
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcClassificationReference
 * ,IfcDocumentReference
 * ,IfcExternallyDefinedHatchStyle
 * ,IfcExternallyDefinedSurfaceStyle
 * ,IfcExternallyDefinedTextFont
 * ,IfcLibraryReference));
 * Location : OPTIONAL IfcURIReference;
 * Identification : OPTIONAL IfcIdentifier;
 * Name : OPTIONAL IfcLabel;
 * INVERSE
 * ExternalReferenceForResources : SET [0:?] OF IfcExternalReferenceRelationship FOR RelatingReference;
 * WHERE
 * WR1 : EXISTS(Identification) OR EXISTS(Location) OR EXISTS(Name);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcexternallydefinedhatchstyle.htm">IfcExternallyDefinedHatchStyle</a>
 */
public class IfcExternallyDefinedHatchStyle extends IfcExternalReference implements IfcFillStyleSelect {


    /**
     * Constructs IfcExternallyDefinedHatchStyle with all required attributes.
     */
    public IfcExternallyDefinedHatchStyle() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcExternallyDefinedHatchStyle with required and optional attributes.
     */
    public IfcExternallyDefinedHatchStyle(IfcURIReference location,IfcIdentifier identification,IfcLabel name) {
        super(location,identification,name);
    }
    private void initCollections() {
    }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(location != null ? StepUtils.toStepValue(location) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}