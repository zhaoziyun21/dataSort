package com.zzy;

import javax.websocket.*;

/**
 * Created by zhaoziyun on 2019/4/15.
 */
@ClientEndpoint()
public class WebsocketClient {
    @OnOpen
    public void onOpen(Session session) {}
    @OnMessage
    public void onMessage(String message) {
        System.out.println("Client onMessage: " + message);
    }
    @OnClose
    public void onClose() {}
}
