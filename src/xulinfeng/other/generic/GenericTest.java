package xulinfeng.other.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xujiahong on 2017/8/23.
 * ======================功能列表======================
 */
public class GenericTest {

    public static void main(String[] args) {
        test3();
    }

    public static void test1(){
        //测试 运行时 泛型的实际类型
        ArrayList a = new ArrayList();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Number> c = new ArrayList<Number>();
        Integer i = new Integer("1");
        b.add(i);
        c.add(i);
        Class c1 = a.getClass();
        Class c2 = b.getClass();
        Class c3 = b.getClass();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c1 == c2); //true
        System.out.println(c2 == c3); //true
    }

    public static void test2(){
        //测试 编译时 泛型的实际类型
        ArrayList<Integer> a = new ArrayList<Integer>();
//        ArrayList<Number> b = a;
    }

    public static void test3(){
        ArrayList<Number> a = new ArrayList<Number>();
        a.add(new Integer("1"));
        a.add(new Double("1.5D"));
        a.add(new Float(("1.5f")));
        for(Number number : a){
            System.out.println(number);
        }
    }


}
