package com.hospital_hr.uitl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午10:04 on 17/2/9.
 * <p>
 * 日期工具
 */
public class MyTimeUtil {

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
     * @param string
     * @return
     */
    public static Date stringDateParse(String string) {
        if (null != string && !"".equals(string)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = format.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        } else {
            return null;
        }
    }
}
