package com.studyjwt.controller;


import com.studyjwt.domain.TokenEntity;
import com.studyjwt.domain.User;
import com.studyjwt.enums.ExpTime;
import com.studyjwt.enums.StatusCode;
import com.studyjwt.mapper.UserMapper;
import com.studyjwt.response.BaseResponse;
import com.studyjwt.util.CheckToken;
import com.studyjwt.util.UserTokenUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserTokenUtilImpl tokenUtil;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/getAll")
    public Object getAll(){
        return userMapper.getAll();
    }

    @GetMapping("/findById")
    public User findById(int id){
        return userMapper.fingById(id);
    }

    @CheckToken
    @GetMapping("findByUsername")
    public BaseResponse findByName(String username,String token){
        User user = tokenUtil.getUser(token);
        System.out.println(user.getId());

        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        Map map = new HashMap();
        User user1 = userMapper.selectByUserName(username);
        map.put("token",token);
        map.put("user",user1);
        baseResponse.setData(map);
        return baseResponse;
    }

    @PostMapping("/login")
    public BaseResponse login(String username,String password){
        String checkpassword=userMapper.selectByUserName(username).getPassword();
        String token=null;

        if(checkpassword.equals(password)){
            User user = new User();
            user.setPassword(password);
            user.setUsername(username);
            token= tokenUtil.create(user, ExpTime.OneDay).getToken();
        }

        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        Map map = new HashMap();
        map.put("token",token);
        baseResponse.setData(map);
        return baseResponse;
    }
}
