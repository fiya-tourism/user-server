package com.fy.login.service.impl;

import com.fy.commons.redis.RedisUtil;
import com.fy.commons.utils.MD5;
import com.fy.commons.utils.RandomNumUtil;
import com.fy.commons.utils.ResultVO;
import com.fy.login.mapper.LoginMapper;
import com.fy.login.service.LoginService;
import com.fy.user.domain.UserVO;
import org.apache.solr.client.solrj.io.eval.IFFTEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;

/**
 * @author 武豫
 * @create 2019-07-21 14:37
 * @desc
 **/
@Service
public class LoginServiceImpl implements LoginService{



    /**
     * 注入Log  写日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);


    @Autowired
    private LoginMapper loginMapper;


    //redis缓存工具类
    @Autowired
    private RedisUtil redisUtil;

    /**
     *  登录方法
     * @param user
     * @return
     */
    @Override
    public UserVO toLogin(UserVO user) {
        ResultVO resultVO = new ResultVO();
        //将密码放到MD5加密
        String md5 = MD5.md5(user.getUserPassword());
        //讲加密完的密码 放到对象中取数据库查询
        user.setUserPassword(md5);
       UserVO userVO = loginMapper.checkPhone(user.getUserPhone());
        if (userVO==null){
            resultVO.setCode(500);
            resultVO.setMsg(" 手机号 或者 密码错误 请修改后重试");
         return null;
        }
        //根据手机号 和密码 进行数据库匹配
        UserVO dbCustomer = loginMapper.toLogin(user);

        if(dbCustomer == null){
            resultVO.setCode(500);

            resultVO.setMsg(" 手机号 或者 密码错误 请修改后重试");
        }else {
            resultVO.setCode(200);
            resultVO.setData(dbCustomer);
            resultVO.setMsg("恭喜您 登录成功!!!");
        }
        return dbCustomer;
    }



    /**
     *  校验手机号
     * @param userVO
     * @return
     */
    @Override
    public ResultVO checkPhone(UserVO userVO) {
        ResultVO resultVO = new ResultVO();
        //根据手机号查询数据  查询不到数据返回null 说明手机号没有被注册
        UserVO dbCustomer = loginMapper.checkPhone(userVO.getUserPhone());
        //查询到customer对象不为空  说明手机号已被注册  提示已存在 请登录或更改手机号
        if(null != dbCustomer){
            resultVO.setMsg("该手机号已经存在 请更改 或进行登录");
            resultVO.setCode(500);
            return resultVO;
        }
        resultVO.setMsg("手机号可以在本平台注册");
        resultVO.setCode(200);
        return resultVO;
    }

    @Override
    public ResultVO register(UserVO user) {
        ResultVO resultVO = new ResultVO();

        //再次调用 校验手机号唯一的接口
        UserVO userVO = loginMapper.checkPhone(user.getUserPhone());
        // 如果 查询到customer对象  说明 该手机号 已被注册
        if(userVO != null) {
            resultVO.setMsg("该手机号已经存在 请更改 或进行登录");
            resultVO.setCode(500);
        }
        //密码加密
        String Md5pass = MD5.md5(user.getUserPassword());
        user.setUserPassword(Md5pass);
        user.setComCreate(new Date());
        user.setComYn(0);
        //真正去保存
        loginMapper.register(user);
        resultVO.setMsg("恭喜你 注册成功");
        resultVO.setCode(200);
        return resultVO;
    }



}
