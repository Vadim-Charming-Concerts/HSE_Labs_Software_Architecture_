package com.example.user.service.controller.validate;

import lombok.Setter;

@Setter
public abstract class ValidateHandler {

  protected ValidateHandler nextHandler;

  abstract void validate(String request);
}