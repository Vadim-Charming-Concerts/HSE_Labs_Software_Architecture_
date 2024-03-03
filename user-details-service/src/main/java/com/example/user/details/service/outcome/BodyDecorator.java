package com.example.user.details.service.outcome;

import com.example.user.details.service.repository.entity.UserDetails;

public class BodyDecorator extends ResponseDecorator {

  private final UserDetails body;

  public BodyDecorator(Response response, UserDetails body) {
    super(response);
    this.body = body;
  }

  @Override
  public EntityResponse getResponse() {
    EntityResponse response = super.getResponse();
    response.setBody(body);
    return response;
  }
}