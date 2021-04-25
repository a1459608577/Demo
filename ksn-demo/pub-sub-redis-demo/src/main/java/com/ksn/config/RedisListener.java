package com.ksn.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/16 14:02
 */
public class RedisListener implements MessageListener {

    /**
     * 处理消息
     * @param message  完整的消息
     * @param pattern  消息的频道
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println(new String(message.getChannel()));
        System.out.println(new String(message.getBody()));
    }
}
