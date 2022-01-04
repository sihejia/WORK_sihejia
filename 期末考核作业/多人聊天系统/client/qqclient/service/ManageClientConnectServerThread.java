package qqclient.service;
import java.util.HashMap;

//该类用于管理线程
public class ManageClientConnectServerThread {
    //把多个线程放入hashmap集合中,key是用户ID，value是线程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();

    //把某个线程放入集合
    public static void addClientConnectServerThread(String userID,ClientConnectServerThread clientConnectServerThread){
        hm.put(userID,clientConnectServerThread);
    }
    //通过userID，可以得到对应线程
    public static ClientConnectServerThread getClientConnectServerThread(String userID){
       return hm.get(userID);
    }

}
