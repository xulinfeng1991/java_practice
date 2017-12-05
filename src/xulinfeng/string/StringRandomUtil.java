package xulinfeng.string;

import java.util.Random;

/**
 * Created by xujiahong on 2017/12/5.
 * ======================功能列表======================
 */
public class StringRandomUtil {

    /**
     * @description 提供32位范围的随机字符串
     * @author xujiahong
     * @param
     * @date 2017/12/5 11:31
     */
    public static String getRandomString32(int scale){
        if(scale<1 || scale>100){
            throw new IllegalArgumentException("scale参数必须是小于等于32的正值");
        }
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i=0;i<scale;i++){
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    //test
    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            System.out.println(getRandomString32(6));
        }
    }
}
