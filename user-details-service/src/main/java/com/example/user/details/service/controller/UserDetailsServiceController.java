package com.example.user.details.service.controller;

import com.example.user.details.service.outcome.ResponseBody;
import com.example.user.details.service.outcome.SuccessResponse;
import com.example.user.details.service.type.DetailsMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-details-service")
public class UserDetailsServiceController {


  @GetMapping("/get-user-details-by-name")
  public ResponseEntity<ResponseBody> getUserDetailsByName(
      @RequestHeader("Authorization") String authorization,
      @RequestParam("userName") String userName) {

    if (userName.equals("Maksim")) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(SuccessResponse.builder()
              .code(HttpStatus.OK.value())
              .message(HttpStatus.OK.getReasonPhrase())
              .details(DetailsMessage.detailsForMaksim.getMessage())
              .build()
          );
    }

    if (userName.equals("John")) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(SuccessResponse.builder()
              .code(HttpStatus.OK.value())
              .message(HttpStatus.OK.getReasonPhrase())
              .details(DetailsMessage.detailsForJohn.getMessage())
              .build()
          );
    }

    return ResponseEntity.status(HttpStatus.OK)
        .body(SuccessResponse.builder()
            .code(HttpStatus.OK.value())
            .message(HttpStatus.OK.getReasonPhrase())
            .details(DetailsMessage.detailsForUnknown.getMessage())
            .build()
        );
  }

  @PostMapping
  public ResponseEntity<ResponseBody> postExample(
      @RequestHeader("Authorization") String authorization,
      @RequestBody String body) {

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            SuccessResponse.builder()
                .code(HttpStatus.CREATED.value())
                .message(HttpStatus.CREATED.getReasonPhrase())
                .details(DetailsMessage.detailsForMaksim.getMessage())
                .build()
        );
  }

  @PutMapping
  public ResponseEntity<ResponseBody> putExample(
      @RequestHeader("Authorization") String authorization,
      @RequestParam("param") String param,
      @RequestBody String body) {

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            SuccessResponse.builder()
                .code(HttpStatus.CREATED.value())
                .message(HttpStatus.CREATED.getReasonPhrase())
                .details(DetailsMessage.detailsForMaksim.getMessage())
                .build()
        );
  }

  @DeleteMapping("delete/{id}")
  public ResponseEntity<ResponseBody> deleteExample(
      @RequestHeader("Authorization") String authorization,
      @PathVariable("id") String id) {

    return ResponseEntity.status(HttpStatus.OK)
        .body(
            SuccessResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .details(DetailsMessage.detailsForMaksim.getMessage())
                .build()
        );
  }

}