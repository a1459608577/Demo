package com.ksn.service;

import cn.hutool.core.date.DatePattern;
import org.springframework.stereotype.Service;

import javax.xml.stream.Location;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/17 20:34
 */
@Service
public class TestLocalDateTimeService {


    /**
     * 测试LocalDate， LocalTime， LocalDateTime
     */
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DatePattern.PURE_DATETIME_MS_PATTERN)).toString());
        System.out.println(new SimpleDateFormat(DatePattern.PURE_DATETIME_MS_PATTERN).format(new Date()));
    }

    /**
     * localDate
     */
    public void date() {
        LocalDate now = LocalDate.now();
        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println(dayOfWeek.get(ChronoField.DAY_OF_WEEK));
    }

    /**
     * localTime
     */
    public void time() {
        LocalTime time = LocalTime.now();
        System.out.println(time.getHour() + ":"  + time.getMinute() + ":" + time.getSecond());
        System.out.println(time.getNano());
    }

    /**
     * localDateTime
     */
    public void localDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        System.out.println(LocalDate.now().atTime(LocalTime.now()));
        System.out.println(LocalTime.now().atDate(LocalDate.now()));
    }

    /**
     * instant
     */
    public void instant() {
        Instant now = Instant.now();
        System.out.println(now);
        // 1970到现在多少秒 时间戳
        System.out.println(now.getEpochSecond());
        // 1970到现在多少毫秒 毫秒数
        System.out.println(now.toEpochMilli());
    }

    /**
     * 格式化时间
     */
    public void format() {LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(now.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(now.getNano());

    }

    /**
     * localDateTime转时间戳
     */
    public void localDateTimeToTimestamp() {
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        Instant instant = LocalDateTime.now().atZone(zoneId).toInstant();
        System.out.println(instant);
        System.out.println(instant.toEpochMilli());
    }

    /**
     * 时间戳转locaDateTime
     */
    public void timestampToLocalDateTime() {
        long l = Instant.now().toEpochMilli();
        System.out.println(l);
        Instant instant = Instant.ofEpochMilli(l);
        System.out.println(instant);
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(LocalDateTime.ofInstant(instant, zoneId));
    }

    /**
     * LocalDateTime转Date
     */
    public void localDateTimeToDate() {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = LocalDateTime.now().atZone(zoneId).toInstant();
        System.out.println(Date.from(instant));
    }

    /**
     * date转换成localDateTime
     */
    public void dateToLocalDateTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
    }
}
