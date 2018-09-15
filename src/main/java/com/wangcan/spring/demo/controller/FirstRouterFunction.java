package com.wangcan.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @program: demo
 * @description: ${description}
 * @author: wangcan
 * @create: 2018-09-12 20:28
 **/
@Configuration
public class FirstRouterFunction {
    @Autowired
    private FirstHanderFunction handerFunction;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/time"), req -> handerFunction.getTime(req))
                .andRoute(GET("/date"), handerFunction::getDate)
                .andRoute(GET("/times"),handerFunction::sendTimePerSec);
    }
}
