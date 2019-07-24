package com.fy.commons.utils;


import java.util.Random;

/**
 * Created by Administrator on 2019/5/20.
 */
public class CodeUtil {

    //生成制定位数的验证码
    public static int drawNum(Integer size) {
        int num=0;
        String nu="";
        for(int i=0;i<size;i++){
            int degree=new Random().nextInt()%30;
            int n=new Random().nextInt(10);
            nu=nu+""+n;
        }
        return Integer.parseInt(nu);
    }

    public static void main(String[] args) {
        System.out.println(drawNum(6));
    }
}
