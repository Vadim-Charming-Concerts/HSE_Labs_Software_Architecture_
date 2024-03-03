package com.example.user.details.service.controller;

import com.example.user.details.service.income.AddUserDetailsRequest;
import com.example.user.details.service.outcome.EntityResponse;
import com.example.user.details.service.repository.entity.UserDetails;
import com.example.user.details.service.service.ProxyUserDetailsService;
import com.example.user.details.service.service.UserDetailsService;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-details-service")
public class UserDetailsServiceController {

  private final UserDetailsService service;
  private final ResponseBuilderWithCommand commandController = new ResponseBuilderWithCommand();

  public UserDetailsServiceController() {
    service = new ProxyUserDetailsService();
  }

  @GetMapping("/get-user-details-by-name")
  public ResponseEntity<EntityResponse> getUserDetailsByName(@RequestHeader("Authorization") String authorization,
      @RequestParam("userName") String userName) {
    try {
      UserDetails userDetails = service.getUserDetailsByName(userName);
      commandController.setCommand(new SuccessResponseCommand());
      return ResponseEntity.ok().body(commandController.buildResponse(userDetails));
    } catch (IllegalArgumentException exception) {
      commandController.setCommand(new FailureResponseCommand());
      return ResponseEntity.badRequest().body(commandController.buildResponse(exception));
    }
  }

  @PostMapping
  public ResponseEntity<EntityResponse> addUserDetails(@RequestHeader("Authorization") String authorization, @RequestBody AddUserDetailsRequest request) {
    service.addUserDetails(request);
    commandController.setCommand(new SuccessResponseWithoutBodyCommand());
    return ResponseEntity.ok().body(commandController.buildResponse(null));
  }

  @PutMapping
  public ResponseEntity<EntityResponse> updateUserDetails(@RequestHeader("Authorization") String authorization, @RequestBody UserDetails details) {
    try {
      service.updateUserDetails(details);
      commandController.setCommand(new SuccessResponseWithoutBodyCommand());
      return ResponseEntity.ok().body(commandController.buildResponse(null));
    } catch (IllegalArgumentException exception) {
      commandController.setCommand(new FailureResponseCommand());
      return ResponseEntity.badRequest().body(commandController.buildResponse(exception));
    }
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<EntityResponse> deleteUserDetails(@RequestHeader("Authorization") String authorization, @PathVariable("id") UUID id) {
    try {
      service.deleteUserDetailsById(id);
      commandController.setCommand(new SuccessResponseWithoutBodyCommand());
      return ResponseEntity.ok().body(commandController.buildResponse(null));
    } catch (IllegalArgumentException exception) {
      commandController.setCommand(new FailureResponseCommand());
      return ResponseEntity.badRequest().body(commandController.buildResponse(exception));
    }
  }
}