package xulinfeng.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xujiahong on 2018/1/23.
 * ======================功能列表======================
 */
public class ListTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("1");
        list.add("1");
        System.out.println(list);
        list.remove("1");//remove方法只删除第一个对象
        System.out.println(list);
    }

}
