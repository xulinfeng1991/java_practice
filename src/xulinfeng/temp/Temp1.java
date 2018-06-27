package xulinfeng.temp;

import java.util.Date;
import java.util.UUID;

/**
 * Created by xujiahong on 2017/12/5.
 * ======================功能列表======================
 */
public class Temp1 {

    public static void main(String[] args) {
        String s = "__GetZoneResult_ = { mts:'1521338', province:'重庆', catName:'中国移动', telString:'15213380818', areaVid:'29404', ispVid:'3236139', carrier:'重庆移动' }";
//        String s = "__GetZoneResult_ = { province:'四川' }";
        System.out.println(s.indexOf("province:"));
        s = s.substring(s.indexOf("province:")+10);
        System.out.println(s);
        s = s.substring(0,s.indexOf("'"));
        System.out.println(s);


    }

}
