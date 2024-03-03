package com.example.user.service.controller.validate;

public class LengthValidateHandler extends ValidateHandler {

  @Override
  void validate(String request) {
    if (request.length() <= 1 || request.length() > 100) {
      throw new IllegalArgumentException("The name must have from 2 to 100 characters");
    } else if (nextHandler != null) {
      nextHandler.validate(request);
    }
  }
}