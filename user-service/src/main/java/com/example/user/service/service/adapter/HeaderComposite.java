package com.example.user.service.service.adapter;

import org.springframework.http.HttpEntity;

public interface HeaderComposite {

  HttpEntity<?> getHeaders();
}