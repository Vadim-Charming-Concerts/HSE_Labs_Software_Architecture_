package com.example.user.details.service.outcome;

import com.example.user.details.service.repository.entity.UserDetails;
import com.example.user.details.service.type.ResponseType;
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