package qqclient.service;

import com.shj.qqcommon.Message;
import com.shj.qqcommon.MessageType;
import com.shj.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

//该类用于完成用户登陆验证和注册
public class UserClientService {
    //11因为可能在其他地方用到user信息，所以做成属性
    private User u = new User();
    //socket应作为属性
    private Socket socket;
    //验证用户是否合法`
    public boolean checkUser(String userID,String pwd){
        boolean b = false;
        //创建对象
        u.setUserId(userID);
        u.setPasswd(pwd);
        //连接服务器

        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//发送user对象



            //读取服务端回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = null;
                ms = (Message) ois.readObject();
            //判断是否登入成功
            if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
                //登陆成功
                //创建一个和服务端保持通讯的线程->创建一个类ClientConnectServerThread
                //等待。。。。。
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.start();
                //为了能在一个客户端开多个线程，把线程放到集合中管理
                ManageClientConnectServerThread.addClientConnectServerThread(userID,clientConnectServerThread);
                b = true;
            }else{//登陆失败，不能启动服务客户的线程，关闭socket
                socket.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;

    }
    //向服务器请求在线用户列表
    public void onlineFriendList(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        //发送给服务器
        //应该先得到当前线程socket对应的Object流
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //写退出客户端并给服务端发送退出系统的message对象
    public void logout(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId()+"退出了系统");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
