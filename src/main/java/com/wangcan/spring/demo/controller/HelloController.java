package com.wangcan.spring.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @program: demo
 * @description: ${description}
 * @author: wangcan
 * @create: 2018-09-12 20:20
 **/
@RestController
public class HelloController {
    @GetMapping("/hello")
    public Mono<String> hello(User user) {
        return Mono.just("Welcome to reactive world ~");
    }
}
