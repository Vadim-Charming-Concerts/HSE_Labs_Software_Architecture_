package com.example.user.service.controller.validate;

import java.util.List;

public class ReservedNameValidateHandler extends ValidateHandler {

  private final List<String> reservedNames = List.of(
      "name",
      "class",
      "lastname",
      "firstname"
  );

  @Override
  void validate(String request) {
    if (reservedNames.contains(request.toLowerCase())) {
      throw new IllegalArgumentException("The name passed contains a reserved word");
    } else if (nextHandler != null) {
      nextHandler.validate(request);
    }
  }
}