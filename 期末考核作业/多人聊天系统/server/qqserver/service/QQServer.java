package qqserver.service;

import com.shj.qqcommon.Message;
import com.shj.qqcommon.MessageType;
import com.shj.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class QQServer {
    private ServerSocket ss = null;
    //创建一个集合放多个用户，如果是这些用户登入则认为i是正确的
    private static HashMap<String,User> validUser = new HashMap<>();

    static {//在静态代码块初始化validUser
        validUser.put("100",new User("100","123456"));
        validUser.put("200",new User("200","123456"));
        validUser.put("300",new User("300","123456"));
        validUser.put("老王",new User("400","123456"));
        validUser.put("小明",new User("500","123456"));
        validUser.put("陈勇",new User("600","123456"));

    }
//验证用户是否合法的方法
    private boolean checkUser(String userID,String passwd){
        User user = validUser.get(userID);
        if(user==null){
            return false;
        }
        if(!user.getPasswd().equals(passwd)){
            return false;
        }
        return true;
    }

        public QQServer() {
            try {
                System.out.println("服务端在端口9999监听");
                ss = new ServerSocket(9999);
                //监听是循环的，
                while (true) {
                    Socket socket = ss.accept();
                    //得到socket关联的输入流
                    ObjectInputStream ois
                            = new ObjectInputStream(socket.getInputStream());
                    User u =(User) ois.readObject();
                    //创建一个Message对象发送给客户端
                    Message message = new Message();
                    //创建一个对象流
                    ObjectOutputStream oos = new
                            ObjectOutputStream(socket.getOutputStream());

                    if(checkUser(u.getUserId(), u.getPasswd())){
                        message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                        oos.writeObject(message);
                        // 创建一个线程，和客户端保持通讯，该线程需要socket对象
                        ServerConnectClientThread serverConnectClientThread =
                                new ServerConnectClientThread(socket, u.getUserId());
                        serverConnectClientThread.start();
                    //把线程对象放到集合中管理
                        ManageServerConnectClientThread.addServerConnectClientThread(u.getUserId(),
                                serverConnectClientThread);

                    }else{
                        System.out.println("用户 id = "+u.getUserId()+"pwd="+u.getPasswd()+"登陆失败");
                        //登陆失败
                        message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                        oos.writeObject(message);
                        oos.close();
                        socket.close();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //如果服务器退出了while，说明服务器不再监听，因此关闭ServerSocket
        }

}
