package client;
import entity.Cmder;
import entity.HeartbeatEntity;
import entity.RPCClient;
import impl.HeartbeatHandler;

import java.net.InetSocketAddress;
import java.util.UUID;

/**
 * 心跳客户端
 */
public class HeartbeatClient implements Runnable {

    private String serverIP = "127.0.0.1";
    private int serverPort = 8089;
    private String nodeID = UUID.randomUUID().toString();
    private boolean isRunning = true;
    //最近的心跳时间
    private long lastHeartbeat;
    //心跳间隔时间 10s
    private long heartBeatInterval = 10*1000;


    @Override
    public void run() {
        try {
            while(isRunning){
                HeartbeatHandler handler = RPCClient.getRemoteProxyObj(HeartbeatHandler.class, new InetSocketAddress(serverIP, serverPort));
                long startTime = System.currentTimeMillis();
                //是否达到发送心跳的周期时间
                if(startTime - lastHeartbeat > heartBeatInterval){
                    System.out.println("send a heart beat");
                    lastHeartbeat = startTime;
                    HeartbeatEntity heartbeatEntity = new HeartbeatEntity();
                    heartbeatEntity.setTime(startTime);
                    heartbeatEntity.setNodeID(nodeID);
                    //向服务器发送心跳，并返回需要执行的命令
                    Cmder cmder = handler.sendHeartBeat(heartbeatEntity);
                    if(!processCommand(cmder)){
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过指令
     * @param cmder
     * @return
     */
    private boolean processCommand(Cmder cmder) {
        System.out.println("nodeId"+cmder.getNodeID());
        return true;
    }
}


