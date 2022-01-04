package impl;


import entity.Cmder;
import entity.HeartbeatEntity;



public interface HeartbeatHandler {
    public Cmder sendHeartBeat(HeartbeatEntity info);
}