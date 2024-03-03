package com.example.user.details.service.service;

import com.example.user.details.service.income.AddUserDetailsRequest;
import com.example.user.details.service.repository.entity.Address;
import com.example.user.details.service.repository.entity.UserDetails;

public class UserDetailsGeneratorFacade {

  private final GenerateDetailsFromRequest detailsFromRequest;
  private final GenerateAddressFromRequest addressFromRequest;

  private final static Address DEFAULT_ADDRESS = new Address(
      "DEFAULT_INDEX",
      "DEFAULT_STREET",
      "DEFAULT_CITY"
  );

  public UserDetailsGeneratorFacade() {
    detailsFromRequest = new GenerateDetailsFromRequest();
    addressFromRequest = new GenerateAddressFromRequest();
  }

  public UserDetails generate(AddUserDetailsRequest request) {
    Address address;
    if (request.getIndex().isBlank() && request.getStreet().isBlank() && request.getCity().isBlank()) {
      address = DEFAULT_ADDRESS.clone();
    } else {
      address = addressFromRequest.generate(request.getIndex(), request.getStreet(), request.getCity());
    }
    return detailsFromRequest.generate(request.getName(), request.getPhoneNumber(), address);
  }
}