package com.howbuild.ifc.v4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * <pre>{@code
 * IfcTransitionCode = ENUMERATION OF
 * (DISCONTINUOUS
 * ,CONTINUOUS
 * ,CONTSAMEGRADIENT
 * ,CONTSAMEGRADIENTSAMECURVATURE);
 * }</pre>
 *
 * @see <a href="https://standards.buildingsmart.org/IFC/DEV/IFC4_2/FINAL/HTML/link/ifctransitioncode.htm">IfcTransitionCode</a>
 */
public enum IfcTransitionCode {DISCONTINUOUS,CONTINUOUS,CONTSAMEGRADIENT,CONTSAMEGRADIENTSAMECURVATURE}