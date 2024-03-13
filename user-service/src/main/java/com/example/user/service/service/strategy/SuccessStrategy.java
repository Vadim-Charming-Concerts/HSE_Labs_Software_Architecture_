package com.example.user.service.service.strategy;

import com.example.user.service.income.EntityResponse;

public class SuccessStrategy implements ResponseStrategy {

  @Override
  public EntityResponse handle(EntityResponse response) {
    return EntityResponse.builder()
        .code(response.getCode())
        .message("A positive response came from the service")
        .details("No details available")
        .body(response.getBody())
        .build();
  }
}