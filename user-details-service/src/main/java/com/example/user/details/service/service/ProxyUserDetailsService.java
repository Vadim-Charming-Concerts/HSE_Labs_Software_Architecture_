package com.example.user.details.service.service;

import com.example.user.details.service.income.AddUserDetailsRequest;
import com.example.user.details.service.repository.entity.UserDetails;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyUserDetailsService implements UserDetailsService {

  private final DefaultUserDetailsService original;

  public ProxyUserDetailsService() {
    original = new DefaultUserDetailsService();
  }

  @Override
  public UserDetails getUserDetailsByName(String name) {
    log.info("Called method for getting UserDetails by name: " + name);
    return original.getUserDetailsByName(name);
  }

  @Override
  public void addUserDetails(AddUserDetailsRequest request) {
    log.info("Called method for adding UserDetails: " + request.toString());
    original.addUserDetails(request);
  }

  @Override
  public void updateUserDetails(UserDetails details) {
    log.info("Called method for updating UserDetails: " + details.toString());
    original.updateUserDetails(details);
  }

  @Override
  public void deleteUserDetailsById(UUID id) {
    log.info("Called method for deleting UserDetails by id: " + id);
    original.deleteUserDetailsById(id);
  }
}