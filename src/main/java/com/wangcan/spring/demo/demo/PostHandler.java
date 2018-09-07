package com.wangcan.spring.demo.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.reactive.function.server.ServerResponse.created;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class PostHandler {

    private final PostRepository posts;

    public PostHandler(PostRepository posts) {
        this.posts = posts;
    }
    /**
     *
     * @author KL
     * @date 2018年1月24日
     * @description: 获取全部实例
     * @return Mono<ServerResponse>
     */
    public Mono<ServerResponse> all(ServerRequest req) {
        return ok().body(posts.findAll(), Post.class);
    }


    public Mono<ServerResponse> create(ServerRequest req) {
        return req.body(BodyExtractors.toMono(Post.class))
                .flatMap(post -> this.posts.createOrUpdate(post))
                .flatMap(p -> created(URI.create("/posts/" + p.getId())).build());
    }


    public Mono<ServerResponse> get(ServerRequest req) {
        return this.posts.findById(Long.valueOf(req.pathVariable("id")))
                .flatMap(post -> ok().syncBody(post))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> update(ServerRequest req) {
        /**
         * Aggregate given monos into a new Mono that will be fulfilled
         * when all of the given Monos have been fulfilled,
         * aggregating their values according to the provided combinator function.
         * An error will cause pending results to be cancelled
         * and immediate error emission to the returned Mono.
         * 根据提供的组合功能聚合它们的值
         */
        return Mono
                .zip(
                        (data) -> {
                            Post p = (Post) data[0]; 	//原始数据
                            Post p2 = (Post) data[1];	//修改的数据
                            p.setTitle(p2.getTitle());
                            p.setContent(p2.getContent());
                            return p;
                        },
                        this.posts.findById(Long.valueOf(req.pathVariable("id"))),
                        req.bodyToMono(Post.class)
                )
                .cast(Post.class)   //Cast the current Mono produced type into a target produced type.
                .flatMap(post -> this.posts.createOrUpdate(post))
                .flatMap(post -> ServerResponse.noContent().build());


    }
    public Mono<ServerResponse> delete(ServerRequest req) {
        /**
         * 服务器成功处理了请求，但没返回任何内容。
         */
        return ServerResponse.noContent().build(this.posts.delete(Long.valueOf(req.pathVariable("id"))));
    }

}
