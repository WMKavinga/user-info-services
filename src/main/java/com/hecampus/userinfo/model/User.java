package com.hecampus.userinfo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
  @Id private String id;
  private String name;
  private String email;
  private String pwd;

  public User() { }

  public User(final String id, final String name, final String email, final String pwd) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.pwd = pwd;
  }
  /**
   * Class getter and setters for above fields.
   */
  public final String getId() {
    return id;
  }

  public final void setId(final String id) {
    this.id = id;
  }

  public final String getName() {
    return name;
  }

  public final void setName(final String name) {
    this.name = name;
  }

  public final String getEmail() {
    return email;
  }

  public final void setEmail(final String email) {
    this.email = email;
  }

  public final String getPwd() {
    return pwd;
  }

  public final void setPwd(final String pwd) {
    this.pwd = pwd;
  }
}
