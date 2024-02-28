package com.proxy.ta.controller;

import com.proxy.ta.dto.UserDto;
import com.proxy.ta.entity.SubscriptionEntity;
import com.proxy.ta.entity.UserEntity;
import com.proxy.ta.request.CreateUserRequest;
import com.proxy.ta.request.SubscriptionRequest;
import com.proxy.ta.service.SubscriptionService;
import com.proxy.ta.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

  private UserService userService;
  private SubscriptionService subscriptionService;

  @PostMapping("/new-user")
  public UserDto createUser(@RequestBody CreateUserRequest request) {
    return userService.createUser(request);
  }

  @GetMapping("/all")
  public List<UserEntity> getAllUsers() {
    return userService.getAll();
  }

  @PostMapping("/subscribe")
  public SubscriptionEntity subscribeOrUnsubscribe(@RequestBody SubscriptionRequest request) {
    return subscriptionService.subscribeOrUnsubscribeToUser(request);
  }

  @PutMapping("/edit")
  public UserDto editUser(@RequestBody CreateUserRequest request, @RequestParam Long userId) {
    return userService.editUser(request, userId);
  }

  @DeleteMapping("/delete")
  public void deleteUser(@RequestParam String userId) {
    userService.deleteUser(userId);
  }

}
