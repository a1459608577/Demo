package com.ksn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/16 11:42
 */
@Configuration
public class RedisConfig {

    @Bean(name = "keySerializer")
    public RedisSerializer getKeySerializer() {
        return new StringRedisSerializer();
    }

    @Bean(name = "valueSerializer")
    public RedisSerializer getValueSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(getKeySerializer());
        redisTemplate.setHashKeySerializer(getKeySerializer());
        redisTemplate.setValueSerializer(getValueSerializer());
        redisTemplate.setHashValueSerializer(getValueSerializer());
        return redisTemplate;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter() {
        return new MessageListenerAdapter(new RedisListener());
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory factory,
                                                                       MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();

        container.setConnectionFactory(factory);

        container.addMessageListener(messageListenerAdapter, new ChannelTopic("__keyevent@0__:expired"));
        return container;
    }
}
