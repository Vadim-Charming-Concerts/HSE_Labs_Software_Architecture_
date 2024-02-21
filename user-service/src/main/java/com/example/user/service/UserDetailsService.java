package com.example.user.service;

import com.example.user.service.outcome.SuccessResponse;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserDetailsService {
   
    private final RestTemplate restTemplate;

    private final HttpHeaders headers = new HttpHeaders();

    @Value("${details-by-name}")
    private String detailsByName;

    public UserDetailsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<SuccessResponse> getUserDetailsByName(String userName) {
//        String url = detailsByName + "/get-user-details-by-name";

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(detailsByName)
            .queryParam("userName", userName)
            .toUriString();

        return restTemplate.exchange(urlTemplate, HttpMethod.GET, getStringHttpEntity(), SuccessResponse.class);
    }

    private HttpEntity<?> getStringHttpEntity() {
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "some-token");

        return new HttpEntity<>(headers);
    }
       

}
