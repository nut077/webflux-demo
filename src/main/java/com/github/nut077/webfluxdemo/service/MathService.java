package com.github.nut077.webfluxdemo.service;

import com.github.nut077.webfluxdemo.dto.ResponseDTO;
import com.github.nut077.webfluxdemo.util.SleepUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
@Slf4j
public class MathService {

  public ResponseDTO findSquare(int req) {
    return new ResponseDTO(req * req);
  }

  public List<ResponseDTO> multiplicationTable(int req) {
    return IntStream.rangeClosed(1, 10)
      .peek(i -> SleepUtil.sleepSeconds(1))
      .peek(i -> log.info("math-service processing: " + i))
      .mapToObj(i -> new ResponseDTO(i * req))
      .toList();
  }
}
