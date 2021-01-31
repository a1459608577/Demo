package com.ksn.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/17 21:23
 */
@Data
public class Book {

    String name;

    /**
     * 将时间戳返回给前端
     * @JsonSerialize(using = LocalDateTimeConverter.class)
     */
    /**
     * 把时间转换成指定格式返回
     * @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateTime;
}
