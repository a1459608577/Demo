package com.ksn.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.ArrayList;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/1 16:10
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.sentinel.master}")
    private String myMaster;

    @Value("${spring.redis.sentinel.nodes}")
    private String[] nodes;


    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
        configuration.setMaster(myMaster);
        ArrayList<RedisNode> redisNodes = new ArrayList<>();
        for (String node : nodes) {
            String[] strs = node.split(":");
            redisNodes.add(new RedisNode(strs[0], Integer.parseInt(strs[1])));
        }
        configuration.setSentinels(redisNodes);
        configuration.setPassword("123456");
        return new LettuceConnectionFactory(configuration);
    }

    @Bean(name = "keySerializer")
    public RedisSerializer getKeySerializer() {
        return new StringRedisSerializer();
    }

    @Bean(name = "valueSerializer")
    public RedisSerializer getValueSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new StringRedisTemplate(redisConnectionFactory);
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory
            ,@Qualifier("keySerializer") RedisSerializer keySerializer
            ,@Qualifier("valueSerializer") RedisSerializer valueSerializer) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setHashKeySerializer(keySerializer);
        redisTemplate.setValueSerializer(valueSerializer);
        redisTemplate.setHashValueSerializer(valueSerializer);
        return redisTemplate;
    }
}
