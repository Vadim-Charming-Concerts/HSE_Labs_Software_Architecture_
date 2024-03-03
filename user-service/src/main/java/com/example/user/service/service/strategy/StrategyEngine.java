package com.example.user.service.service.strategy;

import com.example.user.service.income.EntityResponse;
import lombok.Setter;

@Setter
public class StrategyEngine {

  private ResponseStrategy strategy;

  public EntityResponse getResponse(EntityResponse response){
    return strategy.handle(response);
  }
}