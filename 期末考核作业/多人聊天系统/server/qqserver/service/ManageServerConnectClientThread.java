package qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

//该类用于管理和客户端通讯的线程
public class ManageServerConnectClientThread {
    private static HashMap<String,ServerConnectClientThread> hm = new HashMap();
    //把线程加到hm中
    public static void addServerConnectClientThread(String userID,ServerConnectClientThread serverConnectClientThread){
        hm.put(userID,serverConnectClientThread);
    }
    //根据userID返回一个线程
    public static ServerConnectClientThread getServerConnectClientThread(String userID){
        return hm.get(userID);
    }
    //返回在线用户列表
    public static String getOnlineUser(){
        //遍历hashmap的key
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()){
            onlineUserList += iterator.next().toString()+" ";
        }
        return onlineUserList;
    }
    //从集合中移除某个线程的方法
    public static void removeServerConnectClientThread(String userID){
        hm.remove(userID);
    }

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }
}
