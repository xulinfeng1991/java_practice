package xulinfeng.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * description
 *
 * @author xujiahong
 * @date 2018/5/8
 */
public class DateUtil {

    public static final int ADD_TYPE_SECOND = 1;
    public static final int ADD_TYPE_MINUTE = 2;
    public static final int ADD_TYPE_HOUR = 3;
    public static final int ADD_TYPE_DAY = 4;
    public static final int ADD_TYPE_MONTH = 5;
    public static final int ADD_TYPE_YEAR = 6;

    /*
    解析日期为时间：2018-05-09
    PARSE_DATE_TYPE_START 2018-05-09 00:00:00
    PARSE_DATE_TYPE_END   2018-05-09 23:59:59
     */

    public static final int PARSE_DATE_TYPE_START = 1;
    public static final int PARSE_DATE_TYPE_END = 2;

    public static final String FORMAT_MONTH = "yyyy-MM";
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";



    public static Date getDate(String dateString){
        Date date = null;
        try {
            if(dateString.length()==FORMAT_MONTH.length()){
                date = new SimpleDateFormat(FORMAT_MONTH).parse(dateString);
            }else if(dateString.length()==FORMAT_DATE.length()){
                date = new SimpleDateFormat(FORMAT_DATE).parse(dateString);
            }else{
                date = new SimpleDateFormat(FORMAT_TIME).parse(dateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getString(Date date,String format){
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 将原 Date 对象，加上固定时间（年月日时分秒）
     * 
     * @param source
     * @param type
     * @param scale
     * @return
     */
    public static Date addTime(Date source,int type,int scale) {

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(source);

        switch (type){
            case ADD_TYPE_SECOND:
                calendar.set(Calendar.SECOND,calendar.get(Calendar.SECOND)+scale);
                break;
            case ADD_TYPE_DAY:
                calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+scale);
                break;
            case ADD_TYPE_MONTH:
                calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)+scale);
                break;
            default:break;
        }
        return calendar.getTime();
    }

    public static Date parseStringToTime(String dateString,int parseType){
        SimpleDateFormat format = new SimpleDateFormat(FORMAT_TIME);
        if(dateString==null){
            return null;
        }
        if(dateString.length()==FORMAT_DATE.length()){
            if(parseType==PARSE_DATE_TYPE_START){
                dateString += " 00:00:00";
            }else if(parseType==PARSE_DATE_TYPE_END){
                dateString += " 23:59:59";
            }
        }
        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当月第一天的字符串
     * 入参格式“yyyy-MM”
     * 返回格式“yyyy-MM-dd”
     *
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(String month){
        Date date = null;
        try {
            date = new SimpleDateFormat(FORMAT_MONTH).parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat(FORMAT_DATE).format(date);
    }

    /**
     * 获取当月最后一天的字符串
     * 入参格式“yyyy-MM”
     * 返回格式“yyyy-MM-dd”
     *
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(String month){
        Date date = null;
        try {
            date = new SimpleDateFormat(FORMAT_MONTH).parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));;
        return new SimpleDateFormat(FORMAT_DATE).format(calendar.getTime());
    }

    public static int getMonthGap(Date date1,Date date2){
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(date1);
        aft.setTime(date2);
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        int gap = Math.abs(month+result);
        return gap;
    }

//    public static int getDayGap(Date date1,Date date2){
//        Calendar bef = Calendar.getInstance();
//        Calendar aft = Calendar.getInstance();
//        bef.setTime(date1);
//        aft.setTime(date2);
//        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
//        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
//        int gap = Math.abs(month+result);
//        return gap;
//    }

}
