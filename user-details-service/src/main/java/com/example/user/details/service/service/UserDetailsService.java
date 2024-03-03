package com.example.user.details.service.service;

import com.example.user.details.service.income.AddUserDetailsRequest;
import com.example.user.details.service.repository.entity.UserDetails;
import java.util.UUID;

public interface UserDetailsService {

  UserDetails getUserDetailsByName(String name);

  void addUserDetails(AddUserDetailsRequest request);

  void updateUserDetails(UserDetails details);

  void deleteUserDetailsById(UUID id);
}