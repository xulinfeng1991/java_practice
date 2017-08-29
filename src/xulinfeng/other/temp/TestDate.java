package xulinfeng.other.temp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xujiahong on 2017/8/15.
 * ======================功能列表======================
 */
public class TestDate {


    public static void main(String[] args) {
        Date date1 = new Date();
        date1.setTime(0);
        System.out.println(date1);

        String s = date1.toString();
        System.out.println(s);

        SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = formate.format(new Date(s)).toString();

        System.out.println(dateStr);

    }
}
