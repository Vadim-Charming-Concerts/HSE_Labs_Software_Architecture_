package com.example.user.details.service.outcome;

public class CodeAndMessageDecorator extends ResponseDecorator {

  private final int code;
  private final String message;

  public CodeAndMessageDecorator(Response response, int code, String message) {
    super(response);
    this.code = code;
    this.message = message;
  }

  @Override
  public EntityResponse getResponse() {
    EntityResponse response = super.getResponse();
    response.setCode(code);
    response.setMessage(message);
    return response;
  }
}