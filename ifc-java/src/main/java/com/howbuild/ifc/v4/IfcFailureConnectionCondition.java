package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcFailureConnectionCondition
 * SUBTYPE OF (IfcStructuralConnectionCondition);
 * TensionFailureX : OPTIONAL IfcForceMeasure;
 * TensionFailureY : OPTIONAL IfcForceMeasure;
 * TensionFailureZ : OPTIONAL IfcForceMeasure;
 * CompressionFailureX : OPTIONAL IfcForceMeasure;
 * CompressionFailureY : OPTIONAL IfcForceMeasure;
 * CompressionFailureZ : OPTIONAL IfcForceMeasure;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcfailureconnectioncondition.htm">IfcFailureConnectionCondition</a>
 */
public class IfcFailureConnectionCondition extends IfcStructuralConnectionCondition {
    protected IfcForceMeasure tensionFailureX;
    protected IfcForceMeasure tensionFailureY;
    protected IfcForceMeasure tensionFailureZ;
    protected IfcForceMeasure compressionFailureX;
    protected IfcForceMeasure compressionFailureY;
    protected IfcForceMeasure compressionFailureZ;


    /**
     * Constructs IfcFailureConnectionCondition with all required attributes.
     */
    public IfcFailureConnectionCondition() {

        super();
        initCollections();
    }
    /**
     * Constructs IfcFailureConnectionCondition with required and optional attributes.
     */
    public IfcFailureConnectionCondition(IfcLabel name,IfcForceMeasure tensionFailureX,IfcForceMeasure tensionFailureY,IfcForceMeasure tensionFailureZ,IfcForceMeasure compressionFailureX,IfcForceMeasure compressionFailureY,IfcForceMeasure compressionFailureZ) {
        super(name);
        this.tensionFailureX = tensionFailureX;
        this.tensionFailureY = tensionFailureY;
        this.tensionFailureZ = tensionFailureZ;
        this.compressionFailureX = compressionFailureX;
        this.compressionFailureY = compressionFailureY;
        this.compressionFailureZ = compressionFailureZ;
    }
    private void initCollections() {
    }
    public IfcForceMeasure getTensionFailureX() { return this.tensionFailureX; }
    public void setTensionFailureX(IfcForceMeasure value) { this.tensionFailureX = value; } // optional
    public IfcForceMeasure getTensionFailureY() { return this.tensionFailureY; }
    public void setTensionFailureY(IfcForceMeasure value) { this.tensionFailureY = value; } // optional
    public IfcForceMeasure getTensionFailureZ() { return this.tensionFailureZ; }
    public void setTensionFailureZ(IfcForceMeasure value) { this.tensionFailureZ = value; } // optional
    public IfcForceMeasure getCompressionFailureX() { return this.compressionFailureX; }
    public void setCompressionFailureX(IfcForceMeasure value) { this.compressionFailureX = value; } // optional
    public IfcForceMeasure getCompressionFailureY() { return this.compressionFailureY; }
    public void setCompressionFailureY(IfcForceMeasure value) { this.compressionFailureY = value; } // optional
    public IfcForceMeasure getCompressionFailureZ() { return this.compressionFailureZ; }
    public void setCompressionFailureZ(IfcForceMeasure value) { this.compressionFailureZ = value; } // optional

    
    public String getStepParameters() {
        List<String> parameters = new ArrayList<>();
		parameters.add(name != null ? StepUtils.toStepValue(name) : "$");
		parameters.add(tensionFailureX != null ? StepUtils.toStepValue(tensionFailureX) : "$");
		parameters.add(tensionFailureY != null ? StepUtils.toStepValue(tensionFailureY) : "$");
		parameters.add(tensionFailureZ != null ? StepUtils.toStepValue(tensionFailureZ) : "$");
		parameters.add(compressionFailureX != null ? StepUtils.toStepValue(compressionFailureX) : "$");
		parameters.add(compressionFailureY != null ? StepUtils.toStepValue(compressionFailureY) : "$");
		parameters.add(compressionFailureZ != null ? StepUtils.toStepValue(compressionFailureZ) : "$");
        return String.join("", parameters);
    }
    // inherits no-op finalizeRelationships from BaseIfc

}