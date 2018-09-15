//package com.wangcan.spring.demo.demo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.config.EnableWebFlux;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.web.reactive.function.server.RequestPredicates.*;
//import static org.springframework.web.reactive.function.server.RouterFunctions.route;
//
//@Configuration
//@EnableWebFlux
//public class RouteConfig {
//    @Bean
//    public RouterFunction<ServerResponse> routes(PostHandler postHandler){
//        return route(GET("/posts"), postHandler::all)
//                .andRoute(POST("/posts").and(contentType(APPLICATION_JSON)), postHandler::create)
//                .andRoute(GET("/posts/{id}"), postHandler::get)
//                .andRoute(PUT("/posts/{id}"), postHandler::update)
//                .andRoute(DELETE("/posts/{id}"), postHandler::delete);
//    }
//
//}
