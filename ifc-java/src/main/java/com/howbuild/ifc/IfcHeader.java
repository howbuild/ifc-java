package com.howbuild.ifc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IfcHeader {
  private List<String> description = new ArrayList<>();
  private String implementationLevel;
  private String fileName;
  private Date timestamp;
  private String organization;
  private String preProcessorVersion;
  private String originatingSystem;
  private String ifcSchemaVersion;
  private String authorization;

  public List<String> getDescription() {
    return description;
  }

  public void setDescription(List<String> description) {
    this.description = description;
  }

  public String getImplementationLevel() {
    return implementationLevel;
  }

  public void setImplementationLevel(String implementationLevel) {
    this.implementationLevel = implementationLevel;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public String getPreProcessorVersion() {
    return preProcessorVersion;
  }

  public void setPreProcessorVersion(String preProcessorVersion) {
    this.preProcessorVersion = preProcessorVersion;
  }

  public String getOriginatingSystem() {
    return originatingSystem;
  }

  public void setOriginatingSystem(String originatingSystem) {
    this.originatingSystem = originatingSystem;
  }

  public String getIfcSchemaVersion() {
    return ifcSchemaVersion;
  }

  public void setIfcSchemaVersion(String ifcSchemaVersion) {
    this.ifcSchemaVersion = ifcSchemaVersion;
  }

  public String getAuthorization() {
    return authorization;
  }

  public void setAuthorization(String authorization) {
    this.authorization = authorization;
  }
}
