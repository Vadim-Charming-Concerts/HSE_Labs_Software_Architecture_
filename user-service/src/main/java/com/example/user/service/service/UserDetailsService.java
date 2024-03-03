package com.example.user.service.service;

import com.example.user.service.income.EntityResponse;
import com.example.user.service.service.adapter.AuthorizationHeader;
import com.example.user.service.service.adapter.HeaderComposite;
import com.example.user.service.service.adapter.HeadersAdapter;
import com.example.user.service.service.state.DeliveredState;
import com.example.user.service.service.state.ReadyState;
import com.example.user.service.service.state.Request;
import com.example.user.service.service.strategy.FailureStrategy;
import com.example.user.service.service.strategy.ServerErrorStrategy;
import com.example.user.service.service.strategy.StrategyEngine;
import com.example.user.service.service.strategy.SuccessStrategy;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class UserDetailsService {

  private final RestTemplate restTemplate;

  @Value("${details-by-name}")
  private String detailsByName;

  public EntityResponse getUserDetailsByName(Request request) {
    request.setState(new ReadyState());
    request.logging();
    String urlTemplate = UriComponentsBuilder
        .fromHttpUrl(detailsByName)
        .queryParam("userName", request.getName())
        .toUriString();

    request.setState(new DeliveredState());
    request.logging();
    ResponseEntity<EntityResponse> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, getStringHttpEntity(), EntityResponse.class);

    StrategyEngine engine = new StrategyEngine();
    engine.setStrategy(response.getStatusCode() == HttpStatus.OK ? new SuccessStrategy()
        : response.getStatusCode() == HttpStatus.BAD_REQUEST ? new FailureStrategy()
            : new ServerErrorStrategy());
    return engine.getResponse(response.getBody());
  }

  private HttpEntity<?> getStringHttpEntity() {
    HeaderComposite headerComposite = new HeadersAdapter(new AuthorizationHeader());
    return headerComposite.getHeaders();
  }
}