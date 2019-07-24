package com.fy.login.controller;/**
 * Created by 二哥 on 2019/7/21.
 */

import com.fy.commons.utils.ResultVO;
import com.fy.login.service.LoginService;
import com.fy.user.domain.UserVO;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author 武豫
 * @create 2019-07-21 14:34
 * @desc
 **/
@Api(description ="前台用户登录模块")
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;




    @ApiOperation(value = "登录接口")
    @RequestMapping("toLogin")
    @ResponseBody
    public UserVO toLogin( @RequestParam("userVO") String userVO){
        Gson gson = new Gson();
        UserVO user = gson.fromJson(userVO, UserVO.class);
        return  loginService.toLogin(user);
    }

    @ApiOperation(value = "验证手机号 接口")
    @RequestMapping("checkPhone")
    @ResponseBody
    public ResultVO saveCustomer(@RequestBody UserVO userVO){
        return loginService.checkPhone(userVO);
    }


    /**
     * 注册方法
     * @param
     * @return
     */
    @RequestMapping("register")
    @ApiOperation(value = "注册方法 接口")
    @ResponseBody
    public ResultVO  register(@RequestParam("userVO") String userVO){
        Gson gson = new Gson();
        UserVO user = gson.fromJson(userVO, UserVO.class);
        return  loginService.register(user);
    }

}
