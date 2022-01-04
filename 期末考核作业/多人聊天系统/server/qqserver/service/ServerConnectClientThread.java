package qqserver.service;

import com.shj.qqcommon.Message;
import com.shj.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

//该类对应的对象和某个客户端保持连接
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    private String userID;

    public ServerConnectClientThread(Socket socket, String userID) {
        this.socket = socket;
        this.userID = userID;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("服务端和客户端"+userID+"保持通信，读取数据。。。");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message ms =(Message) ois.readObject();
                //根据message类型做相应的处理
                if (ms.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    System.out.println(ms.getSender()+"要在线用户列表");
                    String onlineUser = ManageServerConnectClientThread.getOnlineUser();
                    //构建一个message对象返回去，包含信息
                    Message  message2= new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(ms.getSender());
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);

                }
                else if(ms.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    System.out.println(ms.getSender()+"退出");
                    //将客户端对应的线程从集合中移除
                    ManageServerConnectClientThread.removeServerConnectClientThread(ms.getSender());
                    socket.close();
                    break;
                }
                else if(ms.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    ServerConnectClientThread serverConnectClientThread =
                            ManageServerConnectClientThread.getServerConnectClientThread(ms.getGetter());
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(ms);//转发消息
                }
                else if(ms.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                    //遍历管理线程的集合，把所有的socket得到，然后转发
                    HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()){
                        String onlineUserId = iterator.next().toString();

                        if(!onlineUserId.equals(ms.getSender())){//排除发送消息的用户
                            ObjectOutputStream oos = new
                                    ObjectOutputStream(hm.get(onlineUserId).getSocket().getOutputStream());
                            oos.writeObject(ms);
                        }
                    }
                }
                    else{
                    System.out.println("其他类型message暂时不处理");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
