package com.example.user.service.controller.validate;

public class ValidationService {

  public static void validate(String request) {
    ValidateHandler handler1 = new BlankValidateHandler();
    ValidateHandler handler2 = new LengthValidateHandler();
    ValidateHandler handler3 = new ReservedNameValidateHandler();
    handler1.setNextHandler(handler2);
    handler2.setNextHandler(handler3);

    handler1.validate(request);
  }
}