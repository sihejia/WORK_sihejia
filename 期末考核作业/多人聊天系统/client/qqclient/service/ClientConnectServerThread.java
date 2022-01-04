package qqclient.service;

import com.shj.qqcommon.Message;
import com.shj.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread {
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("客户端线程，等待读取从服务器发送的消息");
                ObjectInputStream bis = new ObjectInputStream(socket.getInputStream());
                //如果服务端没有发信息，线程会堵塞在这里
               Message ms = (Message) bis.readObject();
                //判断message的类型，然后做相应的处理
                if(ms.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)){
                    String[] onlineUsers = ms.getContent().split(" ");
                    System.out.println("=========当前在线用户列表===========");
                    for(int i=0;i<onlineUsers.length;i++){
                        System.out.println("用户："+onlineUsers[i]);
                    }
                }
                else if(ms.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    //把从服务器端转发的消息显示到控制台
                    System.out.println("\n"+ms.getSender()+" 对 "+ms.getSender()+" 说："+ms.getContent());
                }
                else if(ms.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                    System.out.println("\n"+ms.getSender()+"对所有人说"+ms.getContent());
                }
                else{
                    System.out.println("其他类型message，暂时不处理");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
        public Socket getSocket () {
            return socket;
        }
}