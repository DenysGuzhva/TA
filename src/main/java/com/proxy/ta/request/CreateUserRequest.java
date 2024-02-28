package com.proxy.ta.request;

import lombok.Data;

@Data
public class CreateUserRequest {

  private String firstName;
  private String lastName;
  private String emailAddress;
  private String password;

}
