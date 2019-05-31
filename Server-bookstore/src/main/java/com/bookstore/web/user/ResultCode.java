package com.bookstore.web.user;

public class ResultCode {
    /**
     * 成功
     */
    public static final int SUCCESS = 0,
    /**
     * 失败，注册时用户名已存在
     */
    FAIL_USER_EXIST= -1,
    /**
     * 失败，登陆时用户名不存在
     */
    FAIL_USER_NOT_EXIST= -2,
    /**
     * 失败，登陆时用户名密码不匹配
     */
    FAIL_NOT_MATCH = -3,

    /**
     * 失败，注册时两次密码不同
     */
    FAIL_PSWD_DIFF = -4,

    /**
     * 用户名或密码为空
     */
    FAIL_VALUE_NULL = -5,
    /**
     * 用户名或密码为空
     */
    FAIL_TOTAL_MONEY_NOT_MATCH = -6,
    /**
     * 余额不足
     */
    FAIL_BALANCE_NOT_ENOUGH = -7,
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR = 500;

    int code;

    public ResultCode(int code) {
        this.code = code;
    }

}
