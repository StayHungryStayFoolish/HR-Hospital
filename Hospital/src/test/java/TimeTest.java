import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bonismo@hotmail.com
 * 下午2:36 on 17/5/14.
 */
public class TimeTest {


    /**
     * 时间格式化
     *
     * @param date
     * @return
     */
    @Test
    public static String timeFormat(Date date) {
        if (null != date && !"".equals(date)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String string = format.format(date);
            return string;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(timeFormat(new Date()));

    }
}
