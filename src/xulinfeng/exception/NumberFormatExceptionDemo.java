package xulinfeng.exception;

/**
 * Created by xujiahong on 2017/10/9.
 * ======================功能列表======================
 */
public class NumberFormatExceptionDemo {
    public static void main(String[] args) {
        String a = null;
        String b = "bb";
        Integer c;
//        c = Integer.parseInt(a);//java.lang.NumberFormatException: null
//        c = Integer.parseInt(b);//NumberFormatException: For input string: "bb"
//        c = (Integer)(Object)b;//ClassCastException，通常是父类转换为不对应的子类报错
    }
}
