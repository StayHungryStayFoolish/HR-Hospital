package com.hospital_hr.uitl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午10:04 on 17/2/9.
 * <p>
 * 日期工具
 * <p>
 * HH 是24小时制
 * hh 是12小时制
 * M  是月份
 * m  是小时分钟
 * D  是一年中的天数
 * d  是一个月的天数
 */
public class MyTimeUtil {

    /**
     * 获取当前日期的字符串形式
     *
     * @return
     */
    public static Date nowData() {
        String stringDate = dateFormat(new Date());
        return stringDateParse(stringDate);
    }

    /**
     * 获取当前时间的字符串形式
     *
     * @return
     */
    public static Date nowTime() {
        String stringTime = timeFormat(new Date());
        return stringTimeParse(stringTime);
    }

    /**
     * 根据日期转换为 年月日 时分秒 字符串
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        if (null != date && "".equals(date)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String stringDate = format.format(date);
            return stringDate;
        } else {
            return null;
        }
    }

    /**
     * 日期格式化
     *
     * @param date
     * @return
     */
    public static String dateFormat(Date date) {
        if (null != date && !"".equals(date)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String string = format.format(date);
            return string;
        } else {
            return null;
        }
    }

    /**
     * 时间格式化
     *
     * @param date
     * @return
     */
    public static String timeFormat(Date date) {
        if (null != date && !"".equals(date)) {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            String string = format.format(date);
            return string;
        } else {
            return null;
        }
    }

    /**
     * 日期字符串转日期
     *
     * @param stringDate
     * @return
     */
    public static Date stringDateParse(String stringDate) {
        if (null != stringDate && !"".equals(stringDate)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = format.parse(stringDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        } else {
            return null;
        }
    }

    /**
     * 时间字符串转换为时间
     *
     * @param stringTime
     * @return
     */
    public static Date stringTimeParse(String stringTime) {
        if (null != stringTime && "".equals(stringTime)) {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
            Date date = null;
            try {
                date = format.parse(stringTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        } else {
            return null;
        }
    }
}
