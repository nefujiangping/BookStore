package com.bookstore.controller;

import com.bookstore.service.UserService;
import com.bookstore.web.entity.UserInfo;
import com.bookstore.web.user.Result;
import com.bookstore.web.user.ResultCode;
import com.bookstore.web.user.VueLoginInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/api/login", method = RequestMethod.POST, produces = "application/json; charset:UTF-8")
    public Result login(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult){
//        System.out.println(loginInfoVo);
        if (bindingResult.hasErrors()) {
            String message = String.format("登陆失败，[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return new Result(ResultCode.FAIL_VALUE_NULL, message, null);
        }
        return userService.login(loginInfoVo);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/register", method = RequestMethod.POST, produces = "application/json; charset:UTF-8")
    public Result register(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult){
//        System.out.println(loginInfoVo);
        if (bindingResult.hasErrors()) {
            String message = String.format("登陆失败，[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return new Result(ResultCode.FAIL_VALUE_NULL, message, null);
        }
        return userService.register(loginInfoVo);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/getUserInfo", method = RequestMethod.POST, produces = "application/json; charset:UTF-8")
    public UserInfo getUserInfo(String userId){
//        System.out.println(loginInfoVo);
//        if (bindingResult.hasErrors()) {
//            String message = String.format("登陆失败，[%s]。", bindingResult.getFieldError().getDefaultMessage());
//            return new Result(ResultCode.FAIL_VALUE_NULL, message, null);
//        }
        return userService.getUserInfo(userId);
    }
}
