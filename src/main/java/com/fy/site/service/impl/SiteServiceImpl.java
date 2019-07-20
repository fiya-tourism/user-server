package com.fy.site.service.impl;

import com.fy.site.domain.SiteVO;
import com.fy.site.mapper.SiteMapper;
import com.fy.site.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 武豫
 * @create 2019-07-18 11:22
 * @desc
 **/
@Service
public class SiteServiceImpl implements SiteService{

    /**
     * 注入mapper层
     */
    @Autowired
    private SiteMapper siteMapper;

    /**
     *  根据用户id查询地址
     * @param siteId
     * @return
     */
    @Override
    public List<SiteVO> querySiteList(Integer siteId) {
        List<SiteVO> siteVOList =  siteMapper.querySiteList(siteId);
        return siteVOList;
    }

    /**
     *   新增地址
     * @param siteVO
     * @return
     */
    @Override
    public String add(SiteVO siteVO) {
        //添加逻辑状态  0=展示 1=不展示
        siteVO.setComYn(0);
        //发布时间
        siteVO.setComCreate(new Date());
        siteMapper.add(siteVO);
        return "添加成功";
    }

    @Override
    public void delete(Integer siteId) {
        SiteVO siteVO = new SiteVO();
        //修改时间
        siteVO.setComUpdate(new Date());
        //逻辑状态 =1 不展示用户信息
        siteVO.setComYn(1);
        siteMapper.delete(siteId);
    }


    /**
     *  根据id查询地址信息
     * @param siteId
     * @return
     */
    @Override
    public SiteVO toUpdate(Integer siteId) {
        return siteMapper.toUpdate(siteId);
    }

    /**
     *  修改地址信息
     * @param siteVO
     * @return
     */
    @Override
    public String updataInfo(SiteVO siteVO) {
        //修改时间
        siteVO.setComUpdate(new Date());
        siteMapper.updataInfo(siteVO);
        return "修改成功";
    }
}
