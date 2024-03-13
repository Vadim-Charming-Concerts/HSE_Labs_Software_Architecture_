package com.example.user.service.service.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadyState implements RequestState {

  @Override
  public void logging() {
    log.info("Request is ready");
  }
}