package com.ylz.controller;

import com.ylz.service.impl.MessageByRabbitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMsgController {
    @Autowired
    private MessageByRabbitServiceImpl messageByRabbitService;

    @RequestMapping("/sendmsg")
    public String sendMsg(){
        return this.messageByRabbitService.send();
    }
}
