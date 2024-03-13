package com.example.user.service.service.state;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Request {

  private RequestState state;

  private String name;

  public Request(String name) {
    this.name = name;
    state = new NotSentState();
  }

  public void logging() {
    state.logging();
  }
}