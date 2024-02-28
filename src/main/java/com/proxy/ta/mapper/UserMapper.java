package com.proxy.ta.mapper;

import com.proxy.ta.dto.UserDto;
import com.proxy.ta.entity.UserEntity;
import com.proxy.ta.request.CreateUserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserEntity userRequestToUserEntity(CreateUserRequest request) {
    UserEntity build = UserEntity.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmailAddress())
        .password(request.getPassword())
        .build();
    return build;
  }

  public UserDto userEntityToDto(UserEntity entity) {
    return UserDto.builder()
        .id(entity.getId())
        .firstName(entity.getFirstName())
        .lastName(entity.getLastName())
        .email(entity.getEmail())
        .build();
  }

}
