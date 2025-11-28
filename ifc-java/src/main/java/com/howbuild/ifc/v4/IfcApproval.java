package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcApproval;
 * Identifier : OPTIONAL IfcIdentifier;
 * Name : OPTIONAL IfcLabel;
 * Description : OPTIONAL IfcText;
 * TimeOfApproval : OPTIONAL IfcDateTime;
 * Status : OPTIONAL IfcLabel;
 * Level : OPTIONAL IfcLabel;
 * Qualifier : OPTIONAL IfcText;
 * RequestingApproval : OPTIONAL IfcActorSelect;
 * GivingApproval : OPTIONAL IfcActorSelect;
 * INVERSE
 * HasExternalReferences : SET [0:?] OF IfcExternalReferenceRelationship FOR RelatedResourceObjects;
 * ApprovedObjects : SET [0:?] OF IfcRelAssociatesApproval FOR RelatingApproval;
 * ApprovedResources : SET [0:?] OF IfcResourceApprovalRelationship FOR RelatingApproval;
 * IsRelatedWith : SET [0:?] OF IfcApprovalRelationship FOR RelatedApprovals;
 * Relates : SET [0:?] OF IfcApprovalRelationship FOR RelatingApproval;
 * WHERE
 * HasIdentifierOrName : EXISTS (Identifier) OR EXISTS (Name);
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcapproval.htm">IfcApproval</a>
 */
public class IfcApproval extends BaseIfc implements IfcResourceObjectSelect {
    protected IfcIdentifier identifier;
    protected IfcLabel name;
    protected IfcText description;
    protected IfcDateTime timeOfApproval;
    protected IfcLabel status;
    protected IfcLabel level;
    protected IfcText qualifier;
    protected IfcActorSelect requestingApproval;
    protected IfcActorSelect givingApproval;
    protected Collection<IfcExternalReferenceRelationship> hasExternalReferences;
    protected Collection<IfcRelAssociatesApproval> approvedObjects;
    protected Collection<IfcResourceApprovalRelationship> approvedResources;
    protected Collection<IfcApprovalRelationship> isRelatedWith;
    protected Collection<IfcApprovalRelationship> relates;


    /**
     * Constructs IfcApproval with all required attributes.
     */
    public IfcApproval() {

        super();
        this.hasExternalReferences = new ArrayList<>();
        this.approvedObjects = new ArrayList<>();
        this.approvedResources = new ArrayList<>();
        this.isRelatedWith = new ArrayList<>();
        this.relates = new ArrayList<>();
        initCollections();
    }
    /**
     * Constructs IfcApproval with required and optional attributes.
     */
    public IfcApproval(IfcIdentifier identifier,IfcLabel name,IfcText description,IfcDateTime timeOfApproval,IfcLabel status,IfcLabel level,IfcText qualifier,IfcActorSelect requestingApproval,IfcActorSelect givingApproval) {
        super();
        this.hasExternalReferences = new ArrayList<>();
        this.approvedObjects = new ArrayList<>();
        this.approvedResources = new ArrayList<>();
        this.isRelatedWith = new ArrayList<>();
        this.relates = new ArrayList<>();
        this.identifier = identifier;
        this.name = name;
        this.description = description;
        this.timeOfApproval = timeOfApproval;
        this.status = status;
        this.level = level;
        this.qualifier = qualifier;
        this.requestingApproval = requestingApproval;
        this.givingApproval = givingApproval;
    }
    private void initCollections() {
        this.hasExternalReferences = new ArrayList<>();
        this.approvedObjects = new ArrayList<>();
        this.approvedResources = new ArrayList<>();
        this.isRelatedWith = new ArrayList<>();
        this.relates = new ArrayList<>();
    }
    public IfcIdentifier getIdentifier() { return this.identifier; }
    public void setIdentifier(IfcIdentifier value) { this.identifier = value; } // optional
    public IfcLabel getName() { return this.name; }
    public void setName(IfcLabel value) { this.name = value; } // optional
    public IfcText getDescription() { return this.description; }
    public void setDescription(IfcText value) { this.description = value; } // optional
    public IfcDateTime getTimeOfApproval() { return this.timeOfApproval; }
    public void setTimeOfApproval(IfcDateTime value) { this.timeOfApproval = value; } // optional
    public IfcLabel getStatus() { return this.status; }
    public void setStatus(IfcLabel value) { this.status = value; } // optional
    public IfcLabel getLevel() { return this.level; }
    public void setLevel(IfcLabel value) { this.level = value; } // optional
    public IfcText getQualifier() { return this.qualifier; }
    public void setQualifier(IfcText value) { this.qualifier = value; } // optional
    public IfcActorSelect getRequestingApproval() { return this.requestingApproval; }
    public void setRequestingApproval(IfcActorSelect value) { this.requestingApproval = value; } // optional
    public IfcActorSelect getGivingApproval() { return this.givingApproval; }
    public void setGivingApproval(IfcActorSelect value) { this.givingApproval = value; } // optional
    public Collection<IfcExternalReferenceRelationship> getHasExternalReferences() { return this.hasExternalReferences; }
    public void setHasExternalReferences(Collection<IfcExternalReferenceRelationship> value) { this.hasExternalReferences = value; } // inverse
    public Collection<IfcRelAssociatesApproval> getApprovedObjects() { return this.approvedObjects; }
    public void setApprovedObjects(Collection<IfcRelAssociatesApproval> value) { this.approvedObjects = value; } // inverse
    public Collection<IfcResourceApprovalRelationship> getApprovedResources() { return this.approvedResources; }
    public void setApprovedResources(Collection<IfcResourceApprovalRelationship> value) { this.approvedResources = value; } // inverse
    public Collection<IfcApprovalRelationship> getIsRelatedWith() { return this.isRelatedWith; }
    public void setIsRelatedWith(Collection<IfcApprovalRelationship> value) { this.isRelatedWith = value; } // inverse
    public Collection<IfcApprovalRelationship> getRelates() { return this.relates; }
    public void setRelates(Collection<IfcApprovalRelationship> value) { this.relates = value; } // inverse

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(identifier != null ? StepUtils.toStepValue(identifier) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(timeOfApproval != null ? StepUtils.toStepValue(timeOfApproval) : "$");
		parameters.add(status != null ? StepUtils.toStepValue(status) : "$");
		parameters.add(level != null ? StepUtils.toStepValue(level) : "$");
		parameters.add(qualifier != null ? StepUtils.toStepValue(qualifier) : "$");
		parameters.add(requestingApproval != null ? StepUtils.toStepValue(requestingApproval) : "$");
		parameters.add(givingApproval != null ? StepUtils.toStepValue(givingApproval) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}