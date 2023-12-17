package com.github.nut077.webfluxdemo.controller;

import com.github.nut077.webfluxdemo.dto.ResponseDTO;
import com.github.nut077.webfluxdemo.exception.InputValidationException;
import com.github.nut077.webfluxdemo.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reactive-math")
public class ReactiveMathValidationController {

  private final ReactiveMathService reactiveMathService;

  @GetMapping("/square/{req}/throw")
  public Mono<ResponseDTO> findSquare(@PathVariable int req) {
    if (req < 10 || req > 20) {
      throw new InputValidationException(req);
    }
    return reactiveMathService.findSquare(req);
  }
}
