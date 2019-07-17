package com.fy.user.service.impl;

import com.fy.user.commons.utils.DataGridUtil;
import com.fy.user.commons.utils.PageUtils;
import com.fy.user.commons.utils.StrTool;
import com.fy.user.domain.UserVO;
import com.fy.user.mapper.UserMapper;
import com.fy.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @author 武豫
 * @create 2019-07-15 11:00
 * @desc
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *  查询用户信息 分页 条件查询
     * @param page
     * @return
     */
    @Override
    public DataGridUtil<UserVO> queryUserList(@RequestBody PageUtils page){
        String s = StrTool.humpToLine2(page.getSort());
        page.setSort(s);
        PageHelper.startPage(page.getPage(),page.getRows());
        List<UserVO> list =userMapper.queryUserList(page);
        PageInfo pageInfo = new PageInfo<>(list);
        DataGridUtil<UserVO> dg = new DataGridUtil();
        dg.setRows(list);
        dg.setTotal(pageInfo.getTotal());
        return dg;
    }

    /**
     *  添加用户信息
     * @param userVO
     * @return
     */
    @Override
    public String add(UserVO userVO) {
        //添加逻辑状态  0=展示 1=不展示
        userVO.setComYn(0);
        //发布时间
        userVO.setComCreate(new Date());
        userMapper.add(userVO);
        return "添加成功";

    }

    /**
     *   逻辑删除 用户信息
     * @param
     */
    @Override
    public void delete(@RequestParam("id") Integer id) {
        UserVO userVO = new UserVO();
        //修改时间
        userVO.setComUpdate(new Date());
        //逻辑状态 =1 不展示用户信息
        userVO.setComYn(1);
        userMapper.delete(id);
    }

    /**
     *  根据id 回显用户信息
     * @param userId
     * @return
     */
    @Override
    public UserVO toUpdate(Integer userId) {

        return userMapper.toUpdate(userId);
    }

    /**
     *  根据id修改用户信息
     * @param userVO
     * @return
     */
    @Override
    public String updateInfo(UserVO userVO) {
        //修改时间
        userVO.setComUpdate(new Date());
        userMapper.updateInfo(userVO);
        return "修改成功";
    }
}
