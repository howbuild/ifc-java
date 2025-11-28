package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcClassification
 * SUBTYPE OF (IfcExternalInformation);
 * Source : OPTIONAL IfcLabel;
 * Edition : OPTIONAL IfcLabel;
 * EditionDate : OPTIONAL IfcDate;
 * Name : IfcLabel;
 * Description : OPTIONAL IfcText;
 * Location : OPTIONAL IfcURIReference;
 * ReferenceTokens : OPTIONAL LIST [1:?] OF IfcIdentifier;
 * INVERSE
 * ClassificationForObjects : SET [0:?] OF IfcRelAssociatesClassification FOR RelatingClassification;
 * HasReferences : SET [0:?] OF IfcClassificationReference FOR ReferencedSource;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcexternalinformation.htm">IfcExternalInformation</a>
 */
public abstract class IfcExternalInformation extends BaseIfc implements IfcResourceObjectSelect {


    /**
     * Constructs IfcExternalInformation with all required attributes.
     */
    public IfcExternalInformation() {
        super();
        initCollections();
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}