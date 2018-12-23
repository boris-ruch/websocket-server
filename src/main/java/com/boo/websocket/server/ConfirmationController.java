package com.boo.websocket.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class ConfirmationController {


    @MessageMapping("/topic/confirmation")
    public void confirmed(Task task) {
        log.info("Confirm task completed: {}", task);

    }
}