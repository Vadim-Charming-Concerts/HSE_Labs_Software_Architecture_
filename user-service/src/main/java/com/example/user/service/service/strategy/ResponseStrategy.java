package com.example.user.service.service.strategy;

import com.example.user.service.income.EntityResponse;

public interface ResponseStrategy {

  EntityResponse handle(EntityResponse response);
}