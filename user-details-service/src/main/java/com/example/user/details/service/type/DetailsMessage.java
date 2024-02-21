package com.example.user.details.service.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DetailsMessage {
  detailsForMaksim("Maksim is a cool guy"),
  detailsForJohn("John is bad guy"),
  detailsForUnknown("Unknown guy");

  private final String message;
}