package com.example.user.details.service.repository.entity;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

  private UUID id;
  private String name;
  private Address address;
  private String phoneNumber;

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private final UserDetails details = new UserDetails();

    private Builder() {
    }

    public Builder id(UUID id) {
      details.id = id;
      return this;
    }

    public Builder name(String name) {
      details.name = name;
      return this;
    }

    public Builder address(Address address) {
      details.address = address;
      return this;
    }

    public Builder phoneNumber(String phoneNumber) {
      details.phoneNumber = phoneNumber;
      return this;
    }

    public UserDetails build() {
      return details;
    }
  }
}