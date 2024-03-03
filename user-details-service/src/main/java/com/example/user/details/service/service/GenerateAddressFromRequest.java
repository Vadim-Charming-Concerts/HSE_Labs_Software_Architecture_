package com.example.user.details.service.service;

import com.example.user.details.service.repository.entity.Address;

public class GenerateAddressFromRequest {

  public Address generate(String index, String street, String city) {
    return new Address(index, street, city);
  }
}