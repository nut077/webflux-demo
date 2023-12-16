package com.github.nut077.webfluxdemo.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public record ResponseDTO(LocalDateTime date, int output) {

  public ResponseDTO(LocalDateTime date, int output) {
    this.date = Objects.requireNonNullElseGet(date, LocalDateTime::now);
    this.output = output;
  }

  public ResponseDTO(int output) {
    this(null, output);
  }
}
