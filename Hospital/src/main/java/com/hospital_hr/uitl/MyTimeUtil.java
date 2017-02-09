package com.hospital_hr.uitl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午10:04 on 17/2/9.
 * <p>
 * 日期工具
 */
public class MyTimeUtil {

    public static String dateFormat(Date date) {
        if (null != date && !"".equals(date)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String string = format.format(date);
            return string;
        } else {
            return null;
        }
    }
}
