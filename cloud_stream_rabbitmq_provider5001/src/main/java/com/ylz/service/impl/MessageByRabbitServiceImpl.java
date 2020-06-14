package com.ylz.service.impl;




import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding({Source.class})
@Slf4j
public class MessageByRabbitServiceImpl{
    @Autowired
    private MessageChannel output;

    public String send(){
        String msg= UUID.randomUUID().toString();
        log.info("发送"+msg);
        this.output.send(MessageBuilder.withPayload(msg).build());
        return null;
    }

}
