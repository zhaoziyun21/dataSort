package com.zzy;

import com.zzy.vo.DBColumnVo;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhaoziyun on 2019/4/12.
 */
@ServerEndpoint("/webSocketServer/{username}")
@Component
public class WebSocketServer {
    private static int onlineCount = 0;
    private static Map<String, WebSocketServer> clients = new ConcurrentHashMap<String, WebSocketServer>();
    private Session session;
    private String username;

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) throws IOException {

        this.username = username;
        this.session = session;

        addOnlineCount();
        clients.put(username, this);
        System.out.println("已连接");
    }

    @OnClose
    public void onClose() throws IOException {
        clients.remove(username);
        subOnlineCount();
    }

    @OnMessage
    public void onMessage(String message) throws IOException {

        JSONObject jsonTo = JSONObject.fromObject(message);
        String mes = (String) jsonTo.get("message");

        List<String> tableNames = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        String tableName = "tbl_msg_000";
        String tableSql = "SELECT * FROM " + tableName +" limit 0,1";
        List<DBColumnVo> list = new ArrayList<>();
        PreparedStatement pStemt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://172.16.0.50:3306/db_order_new_000", "root", "123456");
            pStemt =  (PreparedStatement)conn.prepareStatement(tableSql);
            rs = pStemt.executeQuery("show full columns from " + tableName);
            //结果集元数据
            ResultSetMetaData rsmd =  (ResultSetMetaData) pStemt.getMetaData();
            //表列数
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                rs.next();
                DBColumnVo columnVo = new DBColumnVo();
                columnVo.setTableName(tableName);
                columnVo.setColumnDesc(rs.getString("Comment"));
                columnVo.setColumnName(rsmd.getColumnName(i+1));
                columnVo.setColumnTypeName(rsmd.getColumnTypeName(i+1));
                columnVo.setSize(rsmd.getColumnDisplaySize(i+1));
                list.add(columnVo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (Exception e) {
            }
        }


//        if (!jsonTo.get("To").equals("All")){
//            sendMessageTo(mes, jsonTo.get("To").toString());
//        }else{
//            sendMessageAll("给所有人:"+ mes);
//        }

    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public void sendMessageTo(String message, String To) throws IOException {
        for (WebSocketServer item : clients.values()) {
            if (item.username.equals(To) )
                item.session.getAsyncRemote().sendText(message);
        }
    }

    public void sendMessageAll(String message) throws IOException {
        for (WebSocketServer item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    public static synchronized Map<String, WebSocketServer> getClients() {
        return clients;
    }

    public static void main(String[] args) {
        WebSocketServer ws = new WebSocketServer();
        JSONObject jo = new JSONObject();
        jo.put("message","这是后台返回的");
        jo.put("To","1");
    }
}