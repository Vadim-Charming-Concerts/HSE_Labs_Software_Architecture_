package com.example.user.details.service.controller;

import com.example.user.details.service.outcome.EntityResponse;
import com.example.user.details.service.repository.entity.UserDetails;

public class SuccessResponseCommand implements ResponseCommand {

  @Override
  public EntityResponse execute(Object object) {
    return ResponsesList.getSuccessResponse((UserDetails) object);
  }
}