package com.proxy.ta.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {

  private Long id;
  private String firstName;
  private String lastName;
  private String email;

}
