package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcSequenceEnum = ENUMERATION OF
 * (START_START
 * ,START_FINISH
 * ,FINISH_START
 * ,FINISH_FINISH
 * ,USERDEFINED
 * ,NOTDEFINED);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcsequenceenum.htm">IfcSequenceEnum</a>
 */
public enum IfcSequenceEnum {START_START,START_FINISH,FINISH_START,FINISH_FINISH,USERDEFINED,NOTDEFINED}