package com.example.user.service.service.observer;

public interface Subject {

  void addObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers();
}