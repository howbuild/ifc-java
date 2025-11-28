package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>{@code
 * ENTITY IfcStructuralAction
 * ABSTRACT SUPERTYPE OF (ONEOF
 * (IfcStructuralCurveAction
 * ,IfcStructuralPointAction
 * ,IfcStructuralSurfaceAction))
 * SUBTYPE OF (IfcStructuralActivity);
 * DestabilizingLoad : OPTIONAL IfcBoolean;
 * END_ENTITY;
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstructuralaction.htm">IfcStructuralAction</a>
 */
public abstract class IfcStructuralAction extends IfcStructuralActivity {
    protected IfcBoolean destabilizingLoad;

    protected IfcStructuralAction() { initCollections(); }
    /**
     * Constructs IfcStructuralAction with all required attributes.
     */
    public IfcStructuralAction(IfcGloballyUniqueId globalId,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal) {

        super(globalId,appliedLoad,globalOrLocal);
    }
    /**
     * Constructs IfcStructuralAction with required and optional attributes.
     */
    public IfcStructuralAction(IfcGloballyUniqueId globalId,IfcOwnerHistory ownerHistory,IfcLabel name,IfcText description,IfcLabel objectType,IfcObjectPlacement objectPlacement,IfcProductRepresentation representation,IfcStructuralLoad appliedLoad,IfcGlobalOrLocalEnum globalOrLocal,IfcBoolean destabilizingLoad) {
        super(globalId,ownerHistory,name,description,objectType,objectPlacement,representation,appliedLoad,globalOrLocal);
        this.destabilizingLoad = destabilizingLoad;
    }
    private void initCollections() {
    }
    public IfcBoolean getDestabilizingLoad() { return this.destabilizingLoad; }
    public void setDestabilizingLoad(IfcBoolean value) { this.destabilizingLoad = value; } // optional


    // inherits no-op finalizeRelationships from BaseIfc

}