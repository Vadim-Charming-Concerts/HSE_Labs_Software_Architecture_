package com.example.user.details.service.controller;

import com.example.user.details.service.outcome.BodyDecorator;
import com.example.user.details.service.outcome.CodeAndMessageDecorator;
import com.example.user.details.service.outcome.DetailsDecorator;
import com.example.user.details.service.outcome.EntityResponse;
import com.example.user.details.service.outcome.FailureBasicResponse;
import com.example.user.details.service.outcome.Response;
import com.example.user.details.service.outcome.SuccessBasicResponse;
import com.example.user.details.service.repository.entity.UserDetails;

public class ResponsesList {

  static EntityResponse getSuccessResponse(UserDetails userDetails){
    Response firstDecorator = new CodeAndMessageDecorator(new SuccessBasicResponse(), 200, "OK");
    Response secondDecorator = new BodyDecorator(firstDecorator, userDetails);
    return secondDecorator.getResponse();
  }

  static EntityResponse getSuccessResponseWithoutBody() {
    Response firstDecorator = new CodeAndMessageDecorator(new SuccessBasicResponse(), 200, "OK");
    return firstDecorator.getResponse();
  }

  static EntityResponse getFailureResponse(Exception exception) {
    Response firstDecorator = new CodeAndMessageDecorator(new FailureBasicResponse(), 400, "BAD REQUEST");
    Response secondDecorator = new DetailsDecorator(firstDecorator, exception.getMessage());
    return secondDecorator.getResponse();
  }
}