package com.ksn.handle;

import com.ksn.service.UserService;
import com.ksn.service.impl.UserServiceImpl;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/11 16:15
 */
public class Server {

    /**
     * 创建路由信息
     * @return
     */
    public RouterFunction<ServerResponse> routingFunction() {
        // 创建handle对象
        UserService userService = new UserServiceImpl();
        UserHandle userHandle = new UserHandle(userService);

        // 创建路由规则
        return RouterFunctions.route(
                GET("/user/{id}").and(accept(APPLICATION_JSON)), userHandle::getById)
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)), userHandle::getAll);
    }

    /**
     * 创建服务器完成适配
     */
    public void createServer() {
        // 路由和handle完成适配
        RouterFunction<ServerResponse> routingFunction = routingFunction();
        HttpHandler handler = toHttpHandler(routingFunction);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);

        // 创建服务器
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createServer();
        System.out.println("enter to exit");
        System.in.read();
    }

}
