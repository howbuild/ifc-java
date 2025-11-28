package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcStateEnum = ENUMERATION OF
 * (READWRITE
 * ,READONLY
 * ,LOCKED
 * ,READWRITELOCKED
 * ,READONLYLOCKED);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifcstateenum.htm">IfcStateEnum</a>
 */
public enum IfcStateEnum {READWRITE,READONLY,LOCKED,READWRITELOCKED,READONLYLOCKED}