package com.howbuild.ifc;

import java.io.InputStream;

public interface IfcDeserializer {
  IfcModel read(InputStream input) throws Exception;
}
