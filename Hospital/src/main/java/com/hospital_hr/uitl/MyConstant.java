package com.hospital_hr.uitl;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by bonismo@hotmail.com
 * 下午10:52 on 17/2/9.
 * <p>
 * 上下班时间常量
 */
public class MyConstant {

//    可以使用直接读取配置文件的方式, 配置文件 Constant.properties , 此处省略
//    @Value("${AMStartTime}")
//    private static String AMStartTime;

    // 上下班时间
    public static String AMStartTime = "9:00:00";
    public static String AMEndTime = "11:59:59";
    public static String PMStartTime = "15:00:00";
    public static String PMEndTime = "18:00:00";
    public static String OVStartTime = "20:00:00";
    public static String OVEndTime = "22:00:00";

    // 上午/下午/加班分割时间
    public static String AMTime = "8:00:00";
    public static String PMTime = "14:00:00";
    public static String OVTime = "19:00:00";
}
