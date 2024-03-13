package com.example.user.service.service.observer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TokenService implements Subject {

  private List<Observer> observers = new ArrayList<>();

  private String token;

  public TokenService(){
    observers.add(new MementoObserver());
  }

  public String generateToken() {
    token = "Bearer " + (Math.random() * 100 - 50);
    notifyObservers();
    return token;
  }

  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(token);
    }
  }
}