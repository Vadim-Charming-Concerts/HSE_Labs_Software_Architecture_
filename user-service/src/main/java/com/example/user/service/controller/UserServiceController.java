package com.example.user.service.controller;

import com.example.user.service.controller.validate.ValidationService;
import com.example.user.service.income.EntityResponse;
import com.example.user.service.service.state.Request;
import com.example.user.service.service.observer.TokenService;
import com.example.user.service.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class UserServiceController {

  private final UserDetailsService userDetailsService;
  private final TokenService tokenService;

  @GetMapping("/get-user")
  public ResponseEntity<EntityResponse> getUser(@RequestParam("userName") String userName) {
    ValidationService.validate(userName);
    Request request = new Request(userName);
    request.logging();
    EntityResponse response = userDetailsService.getUserDetailsByName(request);
    return ResponseEntity.status(response.getCode()).body(response);
  }

  @GetMapping("/generate-token")
  public ResponseEntity<String> generate() {
    return ResponseEntity.ok().body(tokenService.generateToken());
  }
}