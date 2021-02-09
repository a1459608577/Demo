package com.ksn.demo2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.messaging.StompSubProtocolErrorHandler;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/2/2 17:42
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.setErrorHandler(new StompSubProtocolErrorHandler());
        registry.addEndpoint("/endpointNasus").setAllowedOrigins("*").withSockJS();
        // 表示与这个节点建立连接， 群聊
        registry.addEndpoint("/endpointChatTopic").setAllowedOrigins("*").withSockJS();
        // 单聊
        registry.addEndpoint("/endpointChatQueue").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 客户端给服务端发消息时要带上这个
        registry.setApplicationDestinationPrefixes("/app");
        // 客户端监听地址要加这个前缀，服务端发送消息也要加上这个前缀，订阅地址前缀 这两个得相同
        //，如果enableSimpleBroker带user就可以不下下面这句例子如下，因为setUserDestinationPrefix默认为/user
//        registry.enableSimpleBroker("/topic");
//        registry.setUserDestinationPrefix("/topic");
        registry.enableSimpleBroker("/topic", "/user");
    }
}
