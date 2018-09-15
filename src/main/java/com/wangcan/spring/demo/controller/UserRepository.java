package com.wangcan.spring.demo.controller;

import com.wangcan.spring.demo.controller.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @program: demo
 * @description: ${description}
 * @author: wangcan
 * @create: 2018-09-14 21:14
 **/
public interface UserRepository extends ReactiveCrudRepository<User, String> {
    Mono<User> findByUsername(String username);
    Mono<Long> deleteByUsername(String username);
}
