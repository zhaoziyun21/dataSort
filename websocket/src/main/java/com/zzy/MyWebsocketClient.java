package com.zzy;


import org.springframework.web.socket.client.WebSocketClient;

import javax.websocket.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaoziyun on 2019/4/15.
 */
//@ClientEndpoint()
//public class MyWebsocketClient extends WebSocketClient {
//    @OnOpen
//    public void onOpen(Session session) {}
//    @OnMessage
//    public void onMessage(String message) {
//        System.out.println("Client onMessage: " + message);
//    }
//    @OnClose
//    public void onClose() {}
//
//    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//
//}
