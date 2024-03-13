package com.example.user.details.service.outcome;

public class DetailsDecorator extends ResponseDecorator {

  private final String details;

  public DetailsDecorator(Response response, String details) {
    super(response);
    this.details = details;
  }

  @Override
  public EntityResponse getResponse() {
    EntityResponse response = super.getResponse();
    response.setDetails(details);
    return response;
  }
}