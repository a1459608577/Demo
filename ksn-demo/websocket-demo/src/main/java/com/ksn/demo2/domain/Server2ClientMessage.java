package com.ksn.demo2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/2/4 16:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server2ClientMessage {

    private String sendName;
    private String responseMessage;
    private String receivedName;
    private Boolean isSingle = false;
}
