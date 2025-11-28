package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcApplication;
 * ApplicationDeveloper : IfcOrganization;
 * Version : IfcLabel;
 * ApplicationFullName : IfcLabel;
 * ApplicationIdentifier : IfcIdentifier;
 * UNIQUE
 * UR1 : ApplicationIdentifier;
 * UR2 : ApplicationFullName, Version;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcapplication.htm">IfcApplication</a>
 */
public class IfcApplication extends BaseIfc {
    protected IfcOrganization applicationDeveloper;
    protected IfcLabel version;
    protected IfcLabel applicationFullName;
    protected IfcIdentifier applicationIdentifier;

    protected IfcApplication() { initCollections(); }
    /**
     * Constructs IfcApplication with all required attributes.
     */
    public IfcApplication(IfcOrganization applicationDeveloper,IfcLabel version,IfcLabel applicationFullName,IfcIdentifier applicationIdentifier) {
        super();
        this.applicationDeveloper = applicationDeveloper;
        this.version = version;
        this.applicationFullName = applicationFullName;
        this.applicationIdentifier = applicationIdentifier;
    }
    private void initCollections() {
    }
    public IfcOrganization getApplicationDeveloper() { return this.applicationDeveloper; }
    public void setApplicationDeveloper(IfcOrganization value) { this.applicationDeveloper = value; }
    public IfcLabel getVersion() { return this.version; }
    public void setVersion(IfcLabel value) { this.version = value; }
    public IfcLabel getApplicationFullName() { return this.applicationFullName; }
    public void setApplicationFullName(IfcLabel value) { this.applicationFullName = value; }
    public IfcIdentifier getApplicationIdentifier() { return this.applicationIdentifier; }
    public void setApplicationIdentifier(IfcIdentifier value) { this.applicationIdentifier = value; }

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(applicationDeveloper != null ? StepUtils.toStepValue(applicationDeveloper) : "$");
		parameters.add(version != null ? StepUtils.toStepValue(version) : "$");
		parameters.add(applicationFullName != null ? StepUtils.toStepValue(applicationFullName) : "$");
		parameters.add(applicationIdentifier != null ? StepUtils.toStepValue(applicationIdentifier) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}