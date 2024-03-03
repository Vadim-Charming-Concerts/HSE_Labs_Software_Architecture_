package com.example.user.service.income;

import com.example.user.service.type.ResponseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntityResponse {

  private ResponseType type;
  private int code;
  private String message;
  private String details;
  private UserDetails body;
}