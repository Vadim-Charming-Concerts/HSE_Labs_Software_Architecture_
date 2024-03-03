package com.example.user.service.controller.validate;

public class BlankValidateHandler extends ValidateHandler {

  @Override
  void validate(String request) {
    if (request.isBlank()) {
      throw new IllegalArgumentException("The name passed does not contain any characters");
    } else if (nextHandler != null) {
      nextHandler.validate(request);
    }
  }
}