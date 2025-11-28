package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcRelConnectsElements
 * SUPERTYPE OF (ONEOF
 * (IfcRelConnectsPathElements
 * ,IfcRelConnectsWithRealizingElements))
 * SUBTYPE OF (IfcRelConnects);
 * ConnectionGeometry : OPTIONAL IfcConnectionGeometry;
 * RelatingElement : IfcElement;
 * RelatedElement : IfcElement;
 * WHERE
 * NoSelfReference : RelatingElement :<>: RelatedElement;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcrelconnectspathelements.htm">IfcRelConnectsPathElements</a>
 */
public class IfcRelConnectsPathElements extends IfcRelConnectsElements {
    protected Collection<IfcInteger> relatingPriorities;
    protected Collection<IfcInteger> relatedPriorities;
    protected IfcConnectionTypeEnum relatedConnectionType;
    protected IfcConnectionTypeEnum relatingConnectionType;

    protected IfcRelConnectsPathElements() { initCollections(); }
    /**
     * Constructs IfcRelConnectsPathElements with all required attributes.
     */
    public IfcRelConnectsPathElements(IfcGloballyUniqueId globalId,IfcElement relatingElement,IfcElement relatedElement,Collection<IfcInteger> relatingPriorities,Collection<IfcInteger> relatedPriorities,IfcConnectionTypeEnum relatedConnectionType,IfcConnectionTypeEnum relatingConnectionType) {

        super(globalId,relatingElement,relatedElement);
        this.relatingPriorities = relatingPriorities;
        this.relatedPriorities = relatedPriorities;
        this.relatedConnectionType = relatedConnectionType;
        this.relatingConnectionType = relatingConnectionType;
    }
    /**
     * Constructs IfcRelConnectsPathElements with required and optional attributes.
     */
    public IfcRelConnectsPathElements(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcConnectionGeometry connectionGeometry,IfcElement relatingElement,IfcElement relatedElement,Collection<IfcInteger> relatingPriorities,Collection<IfcInteger> relatedPriorities,IfcConnectionTypeEnum relatedConnectionType,IfcConnectionTypeEnum relatingConnectionType) {
        super(globalId,ownerHistory,name,description,connectionGeometry,relatingElement,relatedElement);
        this.relatingPriorities = relatingPriorities;
        this.relatedPriorities = relatedPriorities;
        this.relatedConnectionType = relatedConnectionType;
        this.relatingConnectionType = relatingConnectionType;
    }
    private void initCollections() {
        this.relatingPriorities = new ArrayList<>();
        this.relatedPriorities = new ArrayList<>();
    }
    public Collection<IfcInteger> getRelatingPriorities() { return this.relatingPriorities; }
    public void setRelatingPriorities(Collection<IfcInteger> value) { this.relatingPriorities = value; }
    public Collection<IfcInteger> getRelatedPriorities() { return this.relatedPriorities; }
    public void setRelatedPriorities(Collection<IfcInteger> value) { this.relatedPriorities = value; }
    public IfcConnectionTypeEnum getRelatedConnectionType() { return this.relatedConnectionType; }
    public void setRelatedConnectionType(IfcConnectionTypeEnum value) { this.relatedConnectionType = value; }
    public IfcConnectionTypeEnum getRelatingConnectionType() { return this.relatingConnectionType; }
    public void setRelatingConnectionType(IfcConnectionTypeEnum value) { this.relatingConnectionType = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(globalId != null ? StepUtils.toStepValue(globalId) : "$");
		parameters.add(ownerHistory != null ? StepUtils.toStepValue(ownerHistory) : "$");
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(description != null ? StepUtils.toStepValue(description) : "$");
		parameters.add(connectionGeometry != null ? StepUtils.toStepValue(connectionGeometry) : "$");
		parameters.add(relatingElement != null ? StepUtils.toStepValue(relatingElement) : "$");
		parameters.add(relatedElement != null ? StepUtils.toStepValue(relatedElement) : "$");
		parameters.add(relatingPriorities != null ? StepUtils.toStepValue(relatingPriorities) : "$");
		parameters.add(relatedPriorities != null ? StepUtils.toStepValue(relatedPriorities) : "$");
		parameters.add(StepUtils.toStepValue(relatedConnectionType));
		parameters.add(StepUtils.toStepValue(relatingConnectionType));
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}