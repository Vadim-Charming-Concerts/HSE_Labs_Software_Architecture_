package com.example.user.service.service.observer;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MementoObserver implements Observer {

  private final List<String> memento = new ArrayList<>();

  @Override
  public void update(String token) {
    log.info("New token: " + token);
    memento.add(token);
  }
}