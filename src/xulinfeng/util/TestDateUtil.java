package xulinfeng.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description
 *
 * @author xujiahong
 * @date 2018/5/14
 */
public class TestDateUtil {
    public static void main(String[] args) {
//        testGetMonthGap();
        testAddTime();
    }




    public static void testAddTime(){
        Date date = new Date();
        Date next = DateUtil.addTime(date,DateUtil.ADD_TYPE_DAY,4);
        Date last = DateUtil.addTime(date,DateUtil.ADD_TYPE_DAY,-4);
        System.out.println(DateUtil.getString(next,DateUtil.FORMAT_TIME));
        System.out.println(DateUtil.getString(last,DateUtil.FORMAT_TIME));
    }

    public static void testParseStringToTime() {
        System.out.println(DateUtil.parseStringToTime("2018-05-09 11:46:34", DateUtil.PARSE_DATE_TYPE_END));
        System.out.println(DateUtil.parseStringToTime("2018-05-09", DateUtil.PARSE_DATE_TYPE_END));
    }

    public static void testGetFirstDayOfMonth() {
        for (int i = 1; i <= 12; i++) {
            String month = "2018-";
            if (i < 10) {
                month += "0" + i;
            } else {
                month += i;
            }

            System.out.println(DateUtil.getFirstDayOfMonth(month));
            System.out.println(DateUtil.getLastDayOfMonth(month));
        }
    }

    public static void testGetMonthGap() {
        String date1 = "2018-05";
        String date2 = "2018-09";
        String date3 = "2018-03";
        String date4 = "2019-01";
        String date5 = "2019-12";
        String date6 = "2017-02";
        String date7 = "2017-11";
        System.out.println(date1 + "======" + date2);
        System.out.println(DateUtil.getMonthGap(DateUtil.getDate(date1), DateUtil.getDate(date2)));
        System.out.println(date1 + "======" + date3);
        System.out.println(DateUtil.getMonthGap(DateUtil.getDate(date1), DateUtil.getDate(date3)));
        System.out.println(date1 + "======" + date4);
        System.out.println(DateUtil.getMonthGap(DateUtil.getDate(date1), DateUtil.getDate(date4)));
        System.out.println(date1 + "======" + date5);
        System.out.println(DateUtil.getMonthGap(DateUtil.getDate(date1), DateUtil.getDate(date5)));
        System.out.println(date1 + "======" + date6);
        System.out.println(DateUtil.getMonthGap(DateUtil.getDate(date1), DateUtil.getDate(date6)));
        System.out.println(date1 + "======" + date7);
        System.out.println(DateUtil.getMonthGap(DateUtil.getDate(date1), DateUtil.getDate(date7)));
    }


}
