package com.example.user.service.service.adapter;

import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class AuthorizationHeader {

  HttpEntity<?> getAuthorizationHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.set("Authorization", "some-token");

    return new HttpEntity<>(headers);
  }
}