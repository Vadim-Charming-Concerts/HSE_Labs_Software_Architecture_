package com.example.user.details.service.repository;

import com.example.user.details.service.repository.entity.UserDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDetailsRepository {

  private static volatile UserDetailsRepository instance;

  private UserDetailsRepository() {
  }

  public static UserDetailsRepository getInstance() {
    UserDetailsRepository localInstance = instance;
    if (localInstance == null) {
      synchronized (UserDetailsRepository.class) {
        localInstance = instance;
        if (localInstance == null) {
          instance = localInstance = new UserDetailsRepository();
        }
      }
    }
    return localInstance;
  }

  private final List<UserDetails> db = new ArrayList<>();

  public UserDetails getUserDetailsByName(String name) {
    return db.stream()
        .filter(details -> details.getName().equals(name))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Not found UserDetails by name"));
  }

  public void addUserDetails(UserDetails details) {
    db.add(details);
  }

  public void updateUserDetails(UserDetails details) {
    UserDetails userDetailsFromDb = getUserDetailsByName(details.getName());
    userDetailsFromDb.setAddress(details.getAddress());
    userDetailsFromDb.setPhoneNumber(details.getPhoneNumber());
  }

  public void deleteUserDetailsById(UUID id) {
    UserDetails userDetails = db.stream()
        .filter(details -> details.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Not found UserDetails by id"));
    db.remove(userDetails);
  }
}