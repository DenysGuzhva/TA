package com.proxy.ta.config.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginReq {

  private String email;
  private String password;

}
