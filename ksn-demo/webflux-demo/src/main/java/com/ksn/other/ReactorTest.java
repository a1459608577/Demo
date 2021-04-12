package com.ksn.other;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/11 14:00
 */
public class ReactorTest {

    public static void main(String[] args) {
        Flux.just(1, 2, 3).subscribe(System.out::println);
        Mono.just("a").subscribe(System.out::println);

        Integer[] arr = {1, 2, 3};
        Flux.fromArray(arr).subscribe(System.out::println);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        Flux.fromIterable(strings).subscribe(System.out::println);

        Stream<String> stream = strings.stream();
        Flux.fromStream(stream).subscribe(System.out::println);
    }
}
