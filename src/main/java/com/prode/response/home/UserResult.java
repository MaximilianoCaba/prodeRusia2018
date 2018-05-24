package com.prode.response.home;

public class UserResult {
    private String userName;
    private String userAvatar;
    private Integer result;

    public UserResult(String userName, Integer result, String userAvatar) {
        this.userName = userName;
        this.userAvatar = userAvatar;
        this.result = result;
    }

    public UserResult() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }
}