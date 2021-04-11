package com.ksn.other;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/11 14:00
 */
public class ReactorTest {

    public static void main(String[] args) {
        Flux.just(1, 2, 3).subscribe(System.out::println);
        Mono.just("a").subscribe(System.out::println);
    }
}
