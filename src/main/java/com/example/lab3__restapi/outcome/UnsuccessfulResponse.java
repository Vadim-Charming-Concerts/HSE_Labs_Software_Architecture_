package com.example.lab3__restapi.outcome;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
public class UnsuccessfulResponse implements ResponseBody {

  private int code;
  private String message;
  private String details;

}