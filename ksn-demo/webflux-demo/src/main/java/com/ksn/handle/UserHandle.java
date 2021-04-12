package com.ksn.handle;

import com.ksn.entity.User;
import com.ksn.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/11 15:43
 */
public class UserHandle {

    private final UserService userService;


    public UserHandle(UserService userService) {
        this.userService = userService;
    }

    /**
     * 根据id查询
     * @param request
     * @return
     */
    public Mono<ServerResponse> getById(ServerRequest request) {
        // 从reques中获取参数
        String id = request.pathVariable("id");

        // 如果参数为空就创建一个空的serverResponse对象返回
        Mono<ServerResponse> build = ServerResponse.notFound().build();

        // 获取user
        Mono<User> userById = userService.getUserById(id);

        return userById.flatMap(person -> ServerResponse.ok(). // 构建返回成功的信息
                contentType(MediaType.APPLICATION_JSON). // 设置返回数据类型
                body(fromObject(person)).switchIfEmpty(build)); // 设置返回的body，如果为空就返回创建的空对象

    }

    // 查所有
    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<User> all = userService.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(all, User.class);
    }

    // 新增
    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        Mono<Void> save = userService.save(userMono);
        return ServerResponse.ok().build(save);
    }
}
