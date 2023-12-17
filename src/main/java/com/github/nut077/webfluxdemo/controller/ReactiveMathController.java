package com.github.nut077.webfluxdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nut077.webfluxdemo.dto.MultiplyRequestDTO;
import com.github.nut077.webfluxdemo.dto.ResponseDTO;
import com.github.nut077.webfluxdemo.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/reactive-math")
public class ReactiveMathController {

  private final ReactiveMathService reactiveMathService;

  @GetMapping("/square/{req}")
  public Mono<ResponseDTO> findSquare(@PathVariable int req) {
    return reactiveMathService.findSquare(req);
  }

  @GetMapping("/table/{req}")
  public Flux<ResponseDTO> multiplicationTable(@PathVariable int req) {
    return reactiveMathService.multiplicationTable(req);
  }

  @GetMapping(value = "/table/{req}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<ResponseDTO> multiplicationTableStream(@PathVariable int req) {
    return reactiveMathService.multiplicationTable(req);
  }

  @SneakyThrows
  @PostMapping("/multiply")
  public Mono<ResponseDTO> multiply(@RequestBody Mono<MultiplyRequestDTO> req, @RequestHeader Map<String, String> headers) {
    log.info(new ObjectMapper().writeValueAsString(headers));
    return reactiveMathService.multiply(req);
  }
}
