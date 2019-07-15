package com.fy.user.service;

import com.fy.user.commons.utils.DataGridUtil;
import com.fy.user.commons.utils.PageUtils;
import com.fy.user.domain.UserVO;

/**
 * Created by 二哥 on 2019/7/15.
 */
public interface UserService {
    /**
     *  查询用户信息 条件查询 分页
     * @param page
     * @return
     */
    DataGridUtil<UserVO> queryUserList(PageUtils page);

    /**
     * 添加用户信息
     * @param userVO
     * @return
     */
    String add(UserVO userVO);

    /**
     *  逻辑删除 用户信息
     * @param userVO
     */
    void delete(UserVO userVO);

    /**
     *  根据id 回显用户信息
     * @param userId
     * @return
     */
    UserVO toUpdate(Integer userId);

    /**
     *  修改用户信息
     * @param userVO
     * @return
     */
    String updateInfo(UserVO userVO);
}
