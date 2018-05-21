package com.prode.response.home;

public class UserResult {
    private String userName;
    private Integer result;

    public UserResult(String userName, Integer result) {
        this.userName = userName;
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
}