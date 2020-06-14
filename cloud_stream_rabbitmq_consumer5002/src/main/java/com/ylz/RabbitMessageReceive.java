package com.ylz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
@Slf4j
public class RabbitMessageReceive {

    @StreamListener(Sink.INPUT)
    public void getMessage(Message<String> message){
            log.info("消费者1号接受到"+message.getPayload());
    }
}
