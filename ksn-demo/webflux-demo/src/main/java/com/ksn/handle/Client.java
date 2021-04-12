package com.ksn.handle;

import com.ksn.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/11 17:29
 */
public class Client {

    public static void main(String[] args) {
        WebClient client = WebClient.create("http://127.0.0.1:26076");

        User block = client.get().uri("/user/{id}", "2").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class).block();
        System.out.println(block.getName());
    }
}
