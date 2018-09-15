package com.wangcan.spring.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void hello() throws Exception{
		WebClient webClient = WebClient.create("http://localhost:8080");   // 1
		Mono<String> resp = webClient
				.get().uri("/hello") // 2
				.retrieve() // 3
				.bodyToMono(String.class);  // 4
		resp.subscribe(System.out::println);    // 5
		TimeUnit.SECONDS.sleep(1);  // 6
	}


	@Test
	public void userList() throws InterruptedException {
		WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build(); // 1
		webClient
				.get().uri("/user")
				.accept(MediaType.APPLICATION_STREAM_JSON) // 2
				.exchange() // 3
				.flatMapMany(response -> response.bodyToFlux(User.class))   // 4
				.doOnNext(System.out::println)  // 5
				.blockLast();   // 6
	}

}
