package com.ksn.com.ksn.controller;

import com.ksn.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/17 21:22
 */
@Controller
public class TestLocalDateTimeController {

    /**
     * 返回给前端指定格式的格式
     * @return
     */
    @GetMapping("test1")
    @ResponseBody
    public Book test1() {
        Book book = new Book();
        book.setName("asdf");
        book.setDateTime(LocalDateTime.now());
        return book;
    }

    /**
     * 接受前端的时间然后转换成指定格式
     * @return
     */
    @GetMapping("test2")
    @ResponseBody
    public Book test2(@RequestBody Book book) {
        return book;
    }
}
