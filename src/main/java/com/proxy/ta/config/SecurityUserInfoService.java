package com.proxy.ta.config;

import com.proxy.ta.entity.UserEntity;
import com.proxy.ta.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecurityUserInfoService implements UserDetailsService {

  private UserRepository userRepository;

  @SneakyThrows
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserEntity user = userRepository.findByEmail(email)
        .orElseThrow((Supplier<Throwable>) () -> new UsernameNotFoundException("User with email: " + email + " not found"));

    List<String> roles = new ArrayList<>();
    roles.add("USER");
    return
        org.springframework.security.core.userdetails.User.builder()
            .username(user.getEmail())
            .password(user.getPassword())
            .roles(roles.toArray(new String[0]))
            .build();
  }
}
