package com.fy.user.mapper;

import com.fy.commons.utils.PageUtils;
import com.fy.user.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 二哥 on 2019/7/15.
 */
@Mapper
public interface UserMapper {

    /**
     *  查询用户信息
     * @param page
     * @return
     */
    List<UserVO> queryUserList(PageUtils page);

    /**
     * 添加用户信息
     * @param userVO
     */
    void add(UserVO userVO);

    /**
     *  逻辑删除用户信息
     * @param
     */
    void delete(Integer id);

    /**
     *  根据id回显用户信息
     * @param userId
     * @return
     */
    UserVO toUpdate(Integer userId);

    /**
     * 修改用户信息
     * @param userVO
     */
    void updateInfo(UserVO userVO);
}
