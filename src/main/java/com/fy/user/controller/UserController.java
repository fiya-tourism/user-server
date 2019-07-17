package com.fy.user.controller;

import com.fy.user.commons.utils.DataGridUtil;
import com.fy.user.commons.utils.PageUtils;
import com.fy.user.commons.utils.ResultVO;
import com.fy.user.domain.UserVO;
import com.fy.user.service.UserService;
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
 * @create 2019-07-15 10:53
 * @desc
 **/
@Api(description = "飞亚旅游-用户模块")
@Controller
@RequestMapping("user")
public class UserController {

    /**
     *  注入service
     */
    @Autowired
    private UserService userService;

    /**
     *  用户查询方法
     * @return
     */
    @ApiOperation(value = "飞亚旅游-用户查询")
    @RequestMapping("queryUserList")
    @ResponseBody
    public DataGridUtil<UserVO> queryUserList(PageUtils page){
        return userService.queryUserList(page);
    }


    /**
     * 添加用户信息
     */

    @ApiOperation(value="添加用户信息")
    @RequestMapping(value = "add")
    @ResponseBody
    public String add(@RequestBody UserVO userVO){
        return userService.add(userVO);
    }

    /**
     *  根据id 逻辑删除用户信息
     * @param
     * @return
     */
    @ApiOperation(value = "删除用户信息")
    @RequestMapping("delete")
    @ResponseBody
    public ResultVO delete(Integer id){
        ResultVO resultVO = new ResultVO();
       try {
           userService.delete(id);
           resultVO.setMsg("删除成功");
       }catch(Exception e){
           resultVO.setMsg("删除失败");
       }
        return resultVO;
    }


    /**
     * 根据id回显用户信息
     * @param userId
     * @return
     */
    @ApiOperation(value = "回显信息")
    @RequestMapping("toUpdate")
    public UserVO toUpdate(Integer userId){
        return userService.toUpdate(userId);
    }

    /**
     * 根据id修改用户信息
     * @param userVO
     * @return
     */
    @ApiOperation(value = "修改用户信息")
    @RequestMapping("updateInfo")
    public String updateInfo(UserVO userVO){
        return userService.updateInfo(userVO);
    }
}
