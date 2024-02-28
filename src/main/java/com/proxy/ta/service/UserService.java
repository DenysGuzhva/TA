package com.proxy.ta.service;

import com.proxy.ta.dto.UserDto;
import com.proxy.ta.entity.UserEntity;
import com.proxy.ta.mapper.UserMapper;
import com.proxy.ta.repository.UserRepository;
import com.proxy.ta.request.CreateUserRequest;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@AllArgsConstructor
public class UserService {

  private final UserMapper userMapper;
  private final UserRepository usersRepository;

  public UserDto createUser(CreateUserRequest request) {
    Optional<UserEntity> userByEmail = usersRepository.findByEmail(request.getEmailAddress());
    if (userByEmail.isPresent()) {
      return userMapper.userEntityToDto(userByEmail.get());
    }
    return userMapper.userEntityToDto(usersRepository.save(userMapper.userRequestToUserEntity(request)));
  }

  public UserDto editUser(CreateUserRequest request, Long userId) {
    Optional<UserEntity> user = usersRepository.findEntityById(userId);
    if (user.isPresent()) {
      return userMapper.userEntityToDto(usersRepository.save(UserEntity
          .builder()
          .id(userId)
          .firstName(request.getFirstName())
          .lastName(request.getLastName())
          .email(request.getEmailAddress())
          .password(request.getPassword()).build()));
    }
    return null;
  }

  public void deleteUser(@RequestParam String userId) {
    usersRepository.deleteById(userId);
  }

  public List<UserEntity> getAll() {
    return usersRepository.findAll();
  }
}
