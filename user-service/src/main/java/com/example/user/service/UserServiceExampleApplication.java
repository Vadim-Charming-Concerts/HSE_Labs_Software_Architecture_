package com.example.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserServiceExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserServiceExampleApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplateBean() {
    return new RestTemplate();
  }
}