package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcExternalInformation
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcClassification
 * ,IfcDocumentInformation
 * ,IfcLibraryInformation));
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifclibraryinformation.htm">IfcLibraryInformation</a>
 */
public class IfcLibraryInformation extends IfcExternalInformation implements IfcLibrarySelect {
    protected IfcLabel name;
    protected IfcLabel version;
    protected IfcActorSelect publisher;
    protected IfcDateTime versionDate;
    protected IfcURIReference location;
    protected IfcText description;
    protected Collection<IfcRelAssociatesLibrary> libraryInfoForObjects;
    protected Collection<IfcLibraryReference> hasLibraryReferences;

    protected IfcLibraryInformation() { initCollections(); }
    /**
     * Constructs IfcLibraryInformation with all required attributes.
     */
    public IfcLibraryInformation(IfcLabel name) {

        super();
        this.libraryInfoForObjects = new ArrayList<>();
        this.hasLibraryReferences = new ArrayList<>();
        this.name = name;
    }
    /**
     * Constructs IfcLibraryInformation with required and optional attributes.
     */
    public IfcLibraryInformation(IfcLabel name,IfcLabel version,IfcActorSelect publisher,IfcDateTime versionDate,IfcURIReference location,IfcText description) {
        super();
        this.libraryInfoForObjects = new ArrayList<>();
        this.hasLibraryReferences = new ArrayList<>();
        this.name = name;
        this.version = version;
        this.publisher = publisher;
        this.versionDate = versionDate;
        this.location = location;
        this.description = description;
    }
    private void initCollections() {
        this.libraryInfoForObjects = new ArrayList<>();
        this.hasLibraryReferences = new ArrayList<>();
    }
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; }
    public IfcLabel getVersion() { return this.version; }
    public void setVersion(IfcLabel value) { this.version = value; } // optional
    public IfcActorSelect getPublisher() { return this.publisher; }
    public void setPublisher(IfcActorSelect value) { this.publisher = value; } // optional
    public IfcDateTime getVersionDate() { return this.versionDate; }
    public void setVersionDate(IfcDateTime value) { this.versionDate = value; } // optional
    public IfcURIReference getLocation() { return this.location; }
    public void setLocation(IfcURIReference value) { this.location = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public Collection<IfcRelAssociatesLibrary> getLibraryInfoForObjects() { return this.libraryInfoForObjects; }
    public void setLibraryInfoForObjects(Collection<IfcRelAssociatesLibrary> value) { this.libraryInfoForObjects = value; } // inverse
    public Collection<IfcLibraryReference> getHasLibraryReferences() { return this.hasLibraryReferences; }
    public void setHasLibraryReferences(Collection<IfcLibraryReference> value) { this.hasLibraryReferences = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(version != null ? StepUtils.toStepValue(version) : "$");
		parameters.add(publisher != null ? StepUtils.toStepValue(publisher) : "$");
		parameters.add(versionDate != null ? StepUtils.toStepValue(versionDate) : "$");
		parameters.add(location != null ? StepUtils.toStepValue(location) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}