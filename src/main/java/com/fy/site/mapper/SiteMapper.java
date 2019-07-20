package com.fy.site.mapper;

import com.fy.site.domain.SiteVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 二哥 on 2019/7/18.
 */
@Mapper
public interface SiteMapper {
    /**
     *  根据用户Id查询地址
     * @param siteId
     * @return
     */
    List<SiteVO> querySiteList(Integer siteId);

    /**
     *   新增地址
     * @param siteVO
     */
    void add(SiteVO siteVO);

    /**
     *  根据id删除地址信息
     * @param siteId
     */
    void delete(Integer siteId);

    /**
     * 根据id查询地址信息
     * @param siteId
     * @return
     */
    SiteVO toUpdate(Integer siteId);

    /**
     *  修改地址信息
     * @param siteVO
     */
    void updataInfo(SiteVO siteVO);
}
