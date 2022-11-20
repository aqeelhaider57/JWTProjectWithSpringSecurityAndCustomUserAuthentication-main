package com.utils;

import org.springframework.stereotype.Service;

@Service
public class UserInfoResponse {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
