package com.proxy.ta.controller;

import com.proxy.ta.config.JwtUtil;
import com.proxy.ta.config.jwt.ErrorRes;
import com.proxy.ta.config.jwt.LoginReq;
import com.proxy.ta.config.jwt.LoginRes;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final JwtUtil jwtUtil;

  @GetMapping("/a")
  public String greeting() {
    return "Hello, World";
  }

  @PostMapping(value = "/login")
  public ResponseEntity<?> login(@RequestBody LoginReq loginReq) {
    try {
      Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword()));
      LoginRes loginRes = new LoginRes(authentication.getName(), jwtUtil.createToken(loginReq));
      return ResponseEntity.ok(loginRes);
    } catch (BadCredentialsException e) {
      ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "Invalid username or password");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    } catch (Exception e) {
      ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
  }

}
