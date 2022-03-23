package com.hecampus.userinfo.dto;

public class UserDTO {

  private String id;
  private String name;
  private String email;
  private String pwd;

  /**
   * Class setter and getters.
   */
  public String getId() {
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
