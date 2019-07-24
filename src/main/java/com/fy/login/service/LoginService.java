package com.fy.login.service;

import com.fy.commons.utils.ResultVO;
import com.fy.user.domain.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 二哥 on 2019/7/21.
 */
public interface LoginService {
    /**
     *   前台用户登录方法
     * @param request
     * @param userVO
     * @param code
     * @return
     */
/*    ResultVO toLogin(HttpServletRequest request, UserVO userVO, String code);*/

    /**
     *  校验手机号
     * @param userVO
     * @return
     */
    ResultVO checkPhone(UserVO userVO);

    UserVO toLogin(UserVO userVO);

    ResultVO register(UserVO user);
}
