package com.example.user.details.service.controller;

import com.example.user.details.service.outcome.EntityResponse;

public class FailureResponseCommand implements ResponseCommand {

  @Override
  public EntityResponse execute(Object object) {
    return ResponsesList.getFailureResponse((Exception) object);
  }
}