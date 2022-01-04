package com.shj.qqcommon;

import java.io.Serial;
import java.io.Serializable;

//表示用户的信息
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String userId;//用户ID
    private String passwd;//用户密码

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
