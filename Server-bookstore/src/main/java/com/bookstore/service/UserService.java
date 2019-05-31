package com.bookstore.service;

import com.bookstore.dbentity.Trade;
import com.bookstore.dbentity.TradeExample;
import com.bookstore.dbentity.User;
import com.bookstore.dbentity.UserExample;
import com.bookstore.mapper.TradeMapper;
import com.bookstore.mapper.UserMapper;
import com.bookstore.web.entity.UserInfo;
import com.bookstore.web.user.Result;
import com.bookstore.web.user.ResultCode;
import com.bookstore.web.user.VueLoginInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    TradeMapper tradeMapper;

    @Autowired
    UserMapper userMapper;

    public Result login(VueLoginInfoVo loginInfoVo){
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(loginInfoVo.getUsername());
        List<User> recalledUser = userMapper.selectByExample(example);
        if(recalledUser.size() == 0){  // username not exists
            return new Result(ResultCode.FAIL_USER_NOT_EXIST, "用户名不存在。", null);
        }
        if(recalledUser.size() == 1){  // only one record recalled
            User user = recalledUser.get(0);  // return to FE
            if(user.getPassword().equals(loginInfoVo.getPassword())){  // match
                user.setBalance(0f);
                user.setPassword("");
                return new Result(ResultCode.SUCCESS, "登陆成功。", user);
            } else {
                return new Result(ResultCode.FAIL_NOT_MATCH, "用户名和密码不匹配。", null);
            }
        }
        return new Result(ResultCode.INTERNAL_SERVER_ERROR, "异常。", null);
    }

    public Result register(VueLoginInfoVo registerInfoVo){
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(registerInfoVo.getUsername());
        List<User> recalledUser = userMapper.selectByExample(example);
        if(recalledUser.size() == 0){   // username is available
            User userToAdd = new User();
            userToAdd.setUserId(registerInfoVo.getUsername());
            userToAdd.setDisplayName(registerInfoVo.getDisplayName());
            userToAdd.setPassword(registerInfoVo.getPassword());
            userToAdd.setBalance(10000f);
            userMapper.insert(userToAdd);
            userToAdd.setPassword("");  // return to FE
            return new Result(ResultCode.SUCCESS, "注册成功。", userToAdd);
        } else {   // username is occupied
            return new Result(ResultCode.FAIL_USER_EXIST, "邮箱已被注册。", null);
        }
    }

    public UserInfo getUserInfo(String userId){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId);
        User user = userMapper.selectByExample(userExample).get(0);
        user.setPassword("");

        TradeExample tradeExample = new TradeExample();
        tradeExample.createCriteria().andUserIdEqualTo(userId);
        List<Trade> trades = tradeMapper.selectByExample(tradeExample);

        return new UserInfo(user, trades);
    }

}
