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
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclibraryreference.htm">IfcLibraryReference</a>
 */
public class IfcLibraryReference extends IfcExternalReference implements IfcLibrarySelect {
    protected IfcText description;
    protected IfcLanguageId language;
    protected IfcLibraryInformation referencedLibrary;
    protected Collection<IfcRelAssociatesLibrary> libraryRefForObjects;


    /**
     * Constructs IfcLibraryReference with all required attributes.
     */
    public IfcLibraryReference() {

        super();
        this.libraryRefForObjects = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcLibraryReference with required and optional attributes.
     */
    public IfcLibraryReference(IfcURIReference location,IfcIdentifier identification,IfcLabel name,IfcText description,IfcLanguageId language,IfcLibraryInformation referencedLibrary) {
        super(location,identification,name);
        this.libraryRefForObjects = new ArrayList<>();
        this.description = description;
        this.language = language;
        this.referencedLibrary = referencedLibrary;
    }
    private void initCollections() {
        this.libraryRefForObjects = new ArrayList<>();
    }
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcLanguageId getLanguage() { return this.language; }
    public void setLanguage(IfcLanguageId value) { this.language = value; } // optional
    public IfcLibraryInformation getReferencedLibrary() { return this.referencedLibrary; }
    public void setReferencedLibrary(IfcLibraryInformation value) { this.referencedLibrary = value; } // optional
    public Collection<IfcRelAssociatesLibrary> getLibraryRefForObjects() { return this.libraryRefForObjects; }
    public void setLibraryRefForObjects(Collection<IfcRelAssociatesLibrary> value) { this.libraryRefForObjects = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(location != null ? StepUtils.toStepValue(location) : "$");
		parameters.add(identification != null ? StepUtils.toStepValue(identification) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(language != null ? StepUtils.toStepValue(language) : "$");
		parameters.add(referencedLibrary != null ? StepUtils.toStepValue(referencedLibrary) : "$");
        return String.join("", parameters);
    }
    @Override public void finalizeRelationships() { this.setIfcLibraryReferenceRelationship(); }
    private void setIfcLibraryReferenceRelationship() {
		if (this.referencedLibrary != null) {
		    if (this.referencedLibrary instanceof IfcLibraryInformation)
		        ((IfcLibraryInformation)this.referencedLibrary).hasLibraryReferences.add(this);
		}
    }
}