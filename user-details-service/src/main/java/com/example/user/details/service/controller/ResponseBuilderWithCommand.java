package com.example.user.details.service.controller;

import com.example.user.details.service.outcome.EntityResponse;
import lombok.Setter;

@Setter
public class ResponseBuilderWithCommand {

  private ResponseCommand command;

  EntityResponse buildResponse(Object object) {
    return command.execute(object);
  }
}