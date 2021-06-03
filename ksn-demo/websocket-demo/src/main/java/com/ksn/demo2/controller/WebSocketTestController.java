package com.ksn.demo2.controller;

import com.ksn.demo2.domain.Client2ServerMessage;
import com.ksn.demo2.domain.Server2ClientMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/2/4 15:58
 */
@RestController
public class WebSocketTestController {

    @Autowired
    SimpMessagingTemplate template;

    /**
     * 群聊实现
     * @param message
     * @return
     */
    @MessageMapping("/hello")
    @SendTo("/nasus/getResponse")
    public Server2ClientMessage say(Client2ServerMessage message) {
        return new Server2ClientMessage("asdf","Hello," + message.getName() + "!", "asdf", true);
    }

    @MessageMapping("/chat")
    public void handleChat(Server2ClientMessage server2ClientMessage) {
        String receivedName = server2ClientMessage.getReceivedName();
        Boolean isSingle = server2ClientMessage.getIsSingle();
        if (isSingle) {
            template.convertAndSend("/topic/queue/notifications", server2ClientMessage);
        } else {
            template.convertAndSendToUser(receivedName, "/queue/notifications", server2ClientMessage);
        }
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        return "map";
    }
}
