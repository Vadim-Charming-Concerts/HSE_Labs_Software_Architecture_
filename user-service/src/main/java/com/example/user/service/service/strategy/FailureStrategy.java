package com.example.user.service.service.strategy;

import com.example.user.service.income.EntityResponse;

public class FailureStrategy implements ResponseStrategy {

  @Override
  public EntityResponse handle(EntityResponse response) {
    return EntityResponse.builder()
        .code(response.getCode())
        .message("Received a negative response from the service.")
        .details("Details from response: " + response.getDetails())
        .build();
  }
}