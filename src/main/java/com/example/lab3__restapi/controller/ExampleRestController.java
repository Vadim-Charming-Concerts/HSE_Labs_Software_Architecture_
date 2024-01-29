package com.example.lab3__restapi.controller;

import com.example.lab3__restapi.outcome.ResponseBody;
import com.example.lab3__restapi.outcome.SuccessResponse;
import com.example.lab3__restapi.type.DetailsMessage;
import lombok.SneakyThrows;
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
@RequestMapping("/my-rest")
public class ExampleRestController {


  @GetMapping
  public ResponseEntity<ResponseBody> getExample(
      @RequestHeader("Authorization") String authorization,
      @RequestParam("param") String param) {

    return ResponseEntity.status(HttpStatus.OK)
        .header("My-Header", "custom/header")
        .body(
            SuccessResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .details(DetailsMessage.success.getMessage())
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
                .details(DetailsMessage.success.getMessage())
                .build()
        );
  }

  @PutMapping
  @SneakyThrows
  public ResponseEntity<ResponseBody> putExample(
      @RequestHeader("Authorization") String authorization,
      @RequestParam("param") String param,
      @RequestBody String body) {

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            SuccessResponse.builder()
                .code(HttpStatus.CREATED.value())
                .message(HttpStatus.CREATED.getReasonPhrase())
                .details(DetailsMessage.success.getMessage())
                .build()
        );
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseBody> deleteExample(
      @RequestHeader("Authorization") String authorization,
      @PathVariable("id") String id) {

    return ResponseEntity.status(HttpStatus.OK)
        .body(
            SuccessResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .details(DetailsMessage.success.getMessage())
                .build()
        );
  }

}