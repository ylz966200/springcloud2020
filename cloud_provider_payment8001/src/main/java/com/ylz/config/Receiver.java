package com.ylz.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Receiver {
    @Value("${server.port}")
    private String serverPort;
    public void receiveMessage(String message) {
        log.info("port是"+serverPort+"接受到msg是"+message );
    }
}
