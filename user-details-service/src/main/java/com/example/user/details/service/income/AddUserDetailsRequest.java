package com.example.user.details.service.income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserDetailsRequest {

  private String name;
  private String phoneNumber;
  private String index;
  private String street;
  private String city;
}