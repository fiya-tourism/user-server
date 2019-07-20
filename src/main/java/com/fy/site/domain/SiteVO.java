package com.fy.site.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 武豫
 * @create 2019-07-18 11:06
 * @desc
 **/
@Data
public class SiteVO {

    //主键id
    private Integer siteId;

    //用户主键
    private Integer userId;

    //收货人姓名
    private String siteName;

    //省份
    private String siteProvince;

    //城市
    private String siteCity;

    //县/区
    private String siteCounty;

    //详细地址
    private String siteParticular;

    //收货人手机号
    private String sitePhone;

    //邮政编码
    private Integer sitePostalcode;

    //默认地址
    private Integer siteDefault;

    //创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date comCreate;

    //修改时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date  comUpdate;

    //状态
    private Integer comYn;
}
