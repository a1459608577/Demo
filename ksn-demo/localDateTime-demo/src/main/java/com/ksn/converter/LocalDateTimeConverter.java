package com.ksn.converter;

import com.alibaba.fastjson.serializer.JSONSerializableSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/17 21:24
 */
public class LocalDateTimeConverter extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber((localDateTime.toInstant(ZoneOffset.of("+8"))).toEpochMilli());
    }
}
