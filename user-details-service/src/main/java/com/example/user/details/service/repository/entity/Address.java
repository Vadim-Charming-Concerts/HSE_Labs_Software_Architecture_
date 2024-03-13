package com.example.user.details.service.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Cloneable {

  private String index;
  private String street;
  private String city;

  @Override
  public Address clone() {
    return new Address(this.index, this.street, this.city);
  }
}