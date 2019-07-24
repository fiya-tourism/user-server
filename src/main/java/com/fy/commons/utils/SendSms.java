package com.fy.commons.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoyumeng on 2019/6/6.
 */

public class SendSms {

    public static final String URL = "http://v.juhe.cn/sms/send";

    public static final String APP_KEY = "9317fbe61c95ab2f79968d8926aca9ff";


     public static Integer httpSms(String phone,Integer code) throws  Exception{



        String mobile = phone;

//        //发送验证码
//        Integer code = CodeUtil.drawNum(6);


        //从第三方短信服务商拿到的短信ID
        Integer tpl_id = 160217;

        //给接口中的占位符替换掉,替换成验证码
        String tpl_value = "#code#="+code;

        Map<String,String> param = new HashMap<String,String>();

        param.put("mobile",mobile);
        param.put("key",APP_KEY);
        param.put("tpl_id",tpl_id+"");
        param.put("tpl_value",tpl_value);
        System.out.println(URL+param);
        String result = ClientUtil.doPost(URL, param);
         System.out.println(result);
        return result.indexOf(3);

    }

}
