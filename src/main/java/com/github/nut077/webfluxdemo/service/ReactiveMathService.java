package com.github.nut077.webfluxdemo.service;

import com.github.nut077.webfluxdemo.dto.MultiplyRequestDTO;
import com.github.nut077.webfluxdemo.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@Slf4j
public class ReactiveMathService {

  public Mono<ResponseDTO> findSquare(int req) {
    return Mono.fromSupplier(() -> req * req)
      .map(ResponseDTO::new);
  }

  public Flux<ResponseDTO> multiplicationTable(int req) {
    return Flux.range(1, 10)
      //.doOnNext(i -> SleepUtil.sleepSeconds(1))
      .delayElements(Duration.ofSeconds(1))
      .doOnNext(i -> log.info("reactive-math-service processing: {}", i))
      .map(i -> new ResponseDTO(i * req));
  }

  public Mono<ResponseDTO> multiply(Mono<MultiplyRequestDTO> req) {
    return req
      .map(m -> m.first() * m.second())
      .map(ResponseDTO::new);
  }
}
