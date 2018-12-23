package com.boo.websocket.server;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {
    private Long id;
    private String gatewayId;
    private String name;
   
}