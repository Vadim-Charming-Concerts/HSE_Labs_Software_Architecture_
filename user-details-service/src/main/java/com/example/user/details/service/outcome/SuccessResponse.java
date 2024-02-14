package com.example.user.details.service.outcome;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuccessResponse implements ResponseBody {

  private int code;
  private String message;
  private String details;

}