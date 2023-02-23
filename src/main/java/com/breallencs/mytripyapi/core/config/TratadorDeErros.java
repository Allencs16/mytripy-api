package com.breallencs.mytripyapi.core.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {
  
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<?> tratarError404(){
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> tratarError400(){
    return ResponseEntity.badRequest().body("null");
  }
}
