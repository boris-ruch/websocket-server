package com.boo.websocket.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
public class TaskSender {
    
    @Value("${gatewayId}")
    private String gatewayId;

    private AtomicLong counter = new AtomicLong();

    @Autowired
    private SimpMessagingTemplate broker;

    @Autowired
    public TaskSender(final SimpMessagingTemplate broker) {
        this.broker = broker;
    }

    @Scheduled(fixedRate = 5000)
    public void run() {

        Task task = Task.builder()
                .id(counter.incrementAndGet())
                .gatewayId(gatewayId)
                .name("Password Reset")
                .build();
        log.info("Sending task: {}", task);
        broker.convertAndSend("/topic/task", task);
    }
}