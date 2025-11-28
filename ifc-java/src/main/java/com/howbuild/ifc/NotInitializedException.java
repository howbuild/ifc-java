package com.howbuild.ifc;

public class NotInitializedException extends Exception {
  private final int id;

  public NotInitializedException(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
}
