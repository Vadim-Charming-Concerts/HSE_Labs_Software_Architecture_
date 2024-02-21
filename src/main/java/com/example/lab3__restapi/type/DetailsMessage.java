package com.example.lab3__restapi.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DetailsMessage {
  success("Request completed");

  private final String message;
}