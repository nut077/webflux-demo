package com.github.nut077.webfluxdemo.exceptionhandler;

import com.github.nut077.webfluxdemo.dto.InputFailedValidationResponseDTO;
import com.github.nut077.webfluxdemo.exception.InputValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InputValidationHandler {

  @ExceptionHandler(InputValidationException.class)
  public ResponseEntity<InputFailedValidationResponseDTO> handlerException(InputValidationException ex) {
    InputFailedValidationResponseDTO responseDTO = new InputFailedValidationResponseDTO(ex.getErrorCode(), ex.getInput(), ex.getMessage());
    return ResponseEntity.badRequest().body(responseDTO);
  }
}
