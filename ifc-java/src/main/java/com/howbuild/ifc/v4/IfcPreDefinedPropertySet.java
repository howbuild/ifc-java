package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcDoorLiningProperties
 * SUBTYPE OF (IfcPreDefinedPropertySet);
 * LiningDepth : OPTIONAL IfcPositiveLengthMeasure;
 * LiningThickness : OPTIONAL IfcNonNegativeLengthMeasure;
 * ThresholdDepth : OPTIONAL IfcPositiveLengthMeasure;
 * ThresholdThickness : OPTIONAL IfcNonNegativeLengthMeasure;
 * TransomThickness : OPTIONAL IfcNonNegativeLengthMeasure;
 * TransomOffset : OPTIONAL IfcLengthMeasure;
 * LiningOffset : OPTIONAL IfcLengthMeasure;
 * ThresholdOffset : OPTIONAL IfcLengthMeasure;
 * CasingThickness : OPTIONAL IfcPositiveLengthMeasure;
 * CasingDepth : OPTIONAL IfcPositiveLengthMeasure;
 * ShapeAspectStyle : OPTIONAL IfcShapeAspect;
 * LiningToPanelOffsetX : OPTIONAL IfcLengthMeasure;
 * LiningToPanelOffsetY : OPTIONAL IfcLengthMeasure;
 * WHERE
 * WR31 : NOT(EXISTS(LiningDepth) AND NOT(EXISTS(LiningThickness)));
 * WR32 : NOT(EXISTS(ThresholdDepth) AND NOT(EXISTS(ThresholdThickness)));
 * WR33 : (EXISTS(TransomOffset) AND EXISTS(TransomThickness)) XOR
 * (NOT(EXISTS(TransomOffset)) AND NOT(EXISTS(TransomThickness)));
 * WR34 : (EXISTS(CasingDepth) AND EXISTS(CasingThickness)) XOR
 * (NOT(EXISTS(CasingDepth)) AND NOT(EXISTS(CasingThickness)));
 * WR35 : (EXISTS(SELF\IfcPropertySetDefinition.DefinesType[1]))
 * AND
 * (
 * ('IFC4.IFCDOORTYPE' IN TYPEOF(SELF\IfcPropertySetDefinition.DefinesType[1]))
 * OR
 * ('IFC4.IFCDOORSTYLE' IN TYPEOF(SELF\IfcPropertySetDefinition.DefinesType[1]))
 * );
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcpredefinedpropertyset.htm">IfcPreDefinedPropertySet</a>
 */
public abstract class IfcPreDefinedPropertySet extends IfcPropertySetDefinition {

    protected IfcPreDefinedPropertySet() { initCollections(); }
    /**
     * Constructs IfcPreDefinedPropertySet with all required attributes.
     */
    public IfcPreDefinedPropertySet(IfcGloballyUniqueId globalId) {

        super(globalId);
    }
    /**
     * Constructs IfcPreDefinedPropertySet with required and optional attributes.
     */
    public IfcPreDefinedPropertySet(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description) {
        super(globalId,ownerHistory,name,description);
    }
    private void initCollections() {
    }


    // inherits no-op finalizeRelationships from BaseIfc

}