package com.fy.site.controller;

import com.fy.commons.utils.PageUtils;
import com.fy.commons.utils.ResultVO;
import com.fy.site.domain.SiteVO;
import com.fy.site.service.SiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 武豫
 * @create 2019-07-18 11:03
 * @desc
 **/
@Api(description="飞亚旅游-地址模块")
@Controller
@RequestMapping("site")
public class SiteController {

    /**
     *  注入service层
     */
    @Autowired
    private SiteService siteService;


    /**
     *   根据用户id查询地址接口
     * @param siteId
     * @return
     */
    @ApiOperation(value="根据用户Id查询地址接口")
    @RequestMapping("querySiteList")
    @ResponseBody
    public List<SiteVO> querySiteList(Integer siteId){
        return siteService.querySiteList(siteId);
    }

    /**
     *  新增地址接口
     * @param siteVO
     * @return
     */
    @ApiOperation(value = "新增地址接口")
    @RequestMapping("add")
    @ResponseBody
    public String add(@RequestBody SiteVO siteVO){
        return siteService.add(siteVO);
    }


    @ApiOperation(value = "根据id删除地址接口")
    @RequestMapping("delete")
    @ResponseBody
    public ResultVO delete(Integer siteId){
        ResultVO resultVO = new ResultVO();
        try {
            siteService.delete(siteId);
            resultVO.setMsg("删除成功");
        }catch(Exception e){
            resultVO.setMsg("删除失败");
        }
        return resultVO;
    }


    /**
     *  根据id查询地址信息
     * @param siteId
     * @return
     */
    @ApiOperation(value = "根据id查询地址信息")
    @RequestMapping("toUpdate")
    @ResponseBody
    public SiteVO toUpdate(Integer siteId){
        return siteService.toUpdate(siteId);
    }


    @ApiOperation(value = "修改地址信息")
    @RequestMapping("updataInfo")
    @ResponseBody
    public String updataInfo(SiteVO siteVO){
        return siteService.updataInfo(siteVO);
    }

}
