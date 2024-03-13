package com.example.user.service.service.strategy;

import com.example.user.service.income.EntityResponse;

public class ServerErrorStrategy implements ResponseStrategy {

  @Override
  public EntityResponse handle(EntityResponse response) {
    return EntityResponse.builder()
        .code(500)
        .message("The server did not respond")
        .build();
  }
}