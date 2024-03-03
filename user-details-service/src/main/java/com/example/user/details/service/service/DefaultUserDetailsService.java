package com.example.user.details.service.service;

import com.example.user.details.service.income.AddUserDetailsRequest;
import com.example.user.details.service.repository.UserDetailsRepository;
import com.example.user.details.service.repository.entity.UserDetails;
import java.util.UUID;

public class DefaultUserDetailsService implements UserDetailsService {

  private final UserDetailsRepository repository = UserDetailsRepository.getInstance();

  @Override
  public UserDetails getUserDetailsByName(String name) {
    return repository.getUserDetailsByName(name);
  }

  @Override
  public void addUserDetails(AddUserDetailsRequest request) {
    UserDetailsGeneratorFacade facade = new UserDetailsGeneratorFacade();
    UserDetails details = facade.generate(request);
    repository.addUserDetails(details);
  }

  @Override
  public void updateUserDetails(UserDetails details) {
    repository.updateUserDetails(details);
  }

  @Override
  public void deleteUserDetailsById(UUID id) {
    repository.deleteUserDetailsById(id);
  }
}