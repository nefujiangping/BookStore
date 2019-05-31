package com.bookstore.web.user;

import javax.validation.constraints.NotBlank;

public class VueLoginInfoVo {

    @NotBlank(message = "用户名不允许为空")
    private String username;

    @NotBlank(message="密码不允许为空")
    private String password;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    private String displayName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "VueLoginInfoVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}