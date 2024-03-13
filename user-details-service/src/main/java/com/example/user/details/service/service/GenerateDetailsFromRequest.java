package com.example.user.details.service.service;

import com.example.user.details.service.repository.entity.Address;
import com.example.user.details.service.repository.entity.UserDetails;
import java.util.UUID;

public class GenerateDetailsFromRequest {

  public UserDetails generate(String name, String phoneNumber, Address address) {
    return UserDetails.builder()
        .id(UUID.randomUUID())
        .name(name)
        .address(address)
        .phoneNumber(phoneNumber)
        .build();
  }
}