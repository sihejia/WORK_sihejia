package qqclient.service;

import com.shj.qqcommon.Message;
import com.shj.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

//该类提供和消息相关的方法
public class MessageClientService {
    public void sendMessageToOne(String content,String senderId,String getterId){
        Message message = new Message();
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSendTime(new Date().toString());//发送时间设置到message对象
        System.out.println(senderId+"对"+getterId+"说：");
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendMessageToAll(String content,String senderId){
        Message message = new Message();
        message.setSender(senderId);
        message.setContent(content);
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
        message.setSendTime(new Date().toString());//发送时间设置到message对象
        System.out.println(senderId+"对所有人说："+content);
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
