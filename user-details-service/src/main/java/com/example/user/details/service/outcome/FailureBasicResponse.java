package com.example.user.details.service.outcome;

import com.example.user.details.service.type.ResponseType;

public class FailureBasicResponse implements Response {

  @Override
  public EntityResponse getResponse() {
    EntityResponse response = new EntityResponse();
    response.setType(ResponseType.FAILURE);
    return response;
  }
}