package com.example.user.service.outcome;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse implements ResponseBody {

  private int code;
  private String message;
  private String details;

}