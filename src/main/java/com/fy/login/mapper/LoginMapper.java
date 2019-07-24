package com.fy.login.mapper;

import com.fy.user.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by 二哥 on 2019/7/21.
 */
@Mapper
public interface LoginMapper {
    /**
     *  登陆方法
     * @param userVO
     * @return
     */
    UserVO toLogin(UserVO user);

    UserVO checkPhone(String userPhone);

    void register(UserVO user);
}
