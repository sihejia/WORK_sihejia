package qqclient.view;

import qqclient.service.MessageClientService;
import qqclient.service.UserClientService;

import java.security.Key;
import java.util.Scanner;

public class QQView {
    private boolean loop = true;//控制是否显示菜单
    private String key = "";//接受用户的键盘输入
    private UserClientService userClientService = new UserClientService();//对象是用于登陆服务/注册的
    private MessageClientService messageClientService = new MessageClientService();//对象用户消息发送

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出程序");


    }
    private void mainMenu(){
        Scanner scanner = null;
        while (loop){
            System.out.println("==========欢迎登入多人通讯系统================");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 2 退出系统");
            System.out.println("请输入你的选择");
            scanner = new Scanner(System.in);
            key = scanner.next();
            //根据用户的输入，来处理不同情况
            switch (key){
                case "1":
                    System.out.println("请输入用户号：");
                    String userID = scanner.next();
                    System.out.println("请输入密码:");
                    String pwd = scanner.next();
                    //这里需要到服务端去验证该用户是否合法，裂开，好多代码
                    //这里编写一个UserClientServer类用于用户登入/注册
                    if(userClientService.checkUser(userID,pwd)){
                        System.out.println("============欢迎（用户"+userID+"）加入多人聊天平台二级菜单==============");
                        //进入二级菜单
                        while (loop){
                            System.out.println("\n===========网络通讯二级菜单 （用户"+userID+"）==============");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 5 退出系统");
                            System.out.println("你的选择是：");
                            key = scanner.next();
                            switch (key){
                                case "1":
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("请输入群发内容：");
                                    String s = scanner.next();
                                    messageClientService.sendMessageToAll(s,userID);

                                    break;
                                case "3":
                                    System.out.println("请输入想聊天的用户（在线）：");
                                    String getterID = scanner.next();
                                    System.out.println("请输入聊天内容：");
                                    String content = scanner.next();
                                    //编写一个方法，把消息发送到服务器
                                    messageClientService.sendMessageToOne(content,userID,getterID);
                                    System.out.println("私聊消息");
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    break;
                                case "5":
                                    userClientService.logout();
                                    loop = false;
                                    break;

                            }

                        }

                    }else {
                        System.out.println("========登陆失败==========");
                    }

                    break;
                case "2":
                    System.out.println("退出系统");
                    loop = false;
                    break;
            }


        }
    }

}
