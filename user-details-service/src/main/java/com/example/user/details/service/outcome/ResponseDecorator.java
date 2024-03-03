package com.example.user.details.service.outcome;

public abstract class ResponseDecorator implements Response {

  protected Response decoratedResponse;

  public ResponseDecorator(Response response) {
    this.decoratedResponse = response;
  }

  @Override
  public EntityResponse getResponse() {
    return decoratedResponse.getResponse();
  }
}