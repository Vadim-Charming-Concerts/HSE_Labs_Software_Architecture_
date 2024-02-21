package com.example.user.service.controller;

import com.example.user.service.UserDetailsService;
import com.example.user.service.outcome.SuccessResponse;
import java.net.URI;
import java.util.Collections;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user-service")
@Configuration
public class UserServiceController {

  @Autowired
  UserDetailsService userDetailsService;

  @GetMapping("/get-user")
  @SneakyThrows
  public ResponseEntity<SuccessResponse> getUser(@RequestParam("userName") String userName) {
    String url = "http://user-details-service:5002/user-details-service/get-user-details-by-name";
//    String url = System.getenv("USER_DETAILS_CONNECTION_URL")
//        + "/user-details-service/get-user-details-by-name?userName=" + userName;

    String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
        .queryParam("userName", userName)
        .toUriString();



    return userDetailsService.getUserDetailsByName(userName);
  }



}
