package com.howbuild.ifc;

public class IfcDeserializeException extends RuntimeException {
  public IfcDeserializeException() {
    super();
  }

  public IfcDeserializeException(String msg) {
    super(msg);
  }

  public IfcDeserializeException(String msg, Throwable cause) {
    super(msg, cause);
  }

  public IfcDeserializeException(Throwable cause) {
    super(cause);
  }
}
