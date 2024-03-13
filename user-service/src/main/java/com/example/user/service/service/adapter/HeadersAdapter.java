package com.example.user.service.service.adapter;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;

@AllArgsConstructor
public class HeadersAdapter implements HeaderComposite {

  private AuthorizationHeader header;

  @Override
  public HttpEntity<?> getHeaders() {
    return header.getAuthorizationHeaders();
  }
}