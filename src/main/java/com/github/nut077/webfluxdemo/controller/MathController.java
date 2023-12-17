package com.github.nut077.webfluxdemo.controller;

import com.github.nut077.webfluxdemo.dto.ResponseDTO;
import com.github.nut077.webfluxdemo.service.MathService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/math")
public class MathController {

  private final MathService mathService;

  @GetMapping("/square/{req}")
  public ResponseDTO findSquare(@PathVariable int req) {
    return mathService.findSquare(req);
  }

  @GetMapping("/table/{req}")
  public List<ResponseDTO>multiplicationTable(@PathVariable int req) {
    return mathService.multiplicationTable(req);
  }
}
