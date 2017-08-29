package xulinfeng.string;

import xulinfeng.common.BeautifulPrint;

/**
 * Created by xujiahong on 2017/7/25.
 * ======================功能列表======================
 */
public class TestString {

    public static void main(String[] args) {
        //一句神奇的话（包含所有英文字母）
        String s = "the quick brown fox jumps over a lazy dog";

        /*
        穷举所有方法
         */
        System.out.println("s:"+s);

        System.out.println("");
        System.out.println("【String类常用方法】"+ BeautifulPrint.star50);
        System.out.println("s.contains(\"fox\"):"+s.contains("fox"));
        System.out.println("s.hashCode():"+s.hashCode());
        System.out.println("s.equals(\"hello world\")"+s.equals("hello world"));
        System.out.println("s.isEmpty():"+s.isEmpty());
        System.out.println("s.charAt(0):"+s.charAt(0));







        System.out.println("");
        System.out.println("【String类其他方法】"+ BeautifulPrint.star50);

        //java.lang.String.codePointAt() 方法返回指定索引处的字符（Unicode代码点）。
        System.out.println("ABC".codePointAt(0));//65
        System.out.println("ABC".codePointAt(1));//66
        System.out.println("ABC".codePointAt(2));//67
//        System.out.println("ABC".codePointAt(3));StringIndexOutOfBoundsException
        System.out.println("123".codePointAt(0));//49
        System.out.println("123".codePointAt(1));//50
        System.out.println("123".codePointAt(2));//51
        System.out.println("徐家洪".codePointAt(0));//24464
        System.out.println("徐家洪".codePointAt(1));//23478
        System.out.println("徐家洪".codePointAt(2));//27946


        System.out.println("123".codePointBefore(1));//49

        System.out.println("12345678".codePointCount(0,6));//3







        System.out.println("");
        System.out.println("【Object类方法】"+ BeautifulPrint.star50);
        System.out.println("s.getClass():"+s.getClass());




    }

}
