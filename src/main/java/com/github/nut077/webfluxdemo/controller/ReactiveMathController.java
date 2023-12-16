package com.github.nut077.webfluxdemo.controller;

import com.github.nut077.webfluxdemo.dto.ResponseDTO;
import com.github.nut077.webfluxdemo.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("reactive-math")
public class ReactiveMathController {

  private final ReactiveMathService reactiveMathService;

  @GetMapping("/square/{input}")
  public Mono<ResponseDTO> findSquare(@PathVariable int input) {
    return reactiveMathService.findSquare(input);
  }

  @GetMapping("/table/{input}")
  public Flux<ResponseDTO> multiplicationTable(@PathVariable int input) {
    return reactiveMathService.multiplicationTable(input);
  }

  @GetMapping(value = "/table/{input}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<ResponseDTO> multiplicationTableStream(@PathVariable int input) {
    return reactiveMathService.multiplicationTable(input);
  }
}
