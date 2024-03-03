package com.example.user.details.service.controller;

import com.example.user.details.service.outcome.EntityResponse;

public interface ResponseCommand {

  EntityResponse execute(Object object);
}