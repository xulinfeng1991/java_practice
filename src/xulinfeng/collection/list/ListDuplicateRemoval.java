package xulinfeng.collection.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xujiahong on 2017/7/20.
 * ======================功能列表======================
 * 测试 list 的去重方案
 */
public class ListDuplicateRemoval {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(1);
        list1.add(3);
        list1.add(5);
//        List<Integer> list2 = new ArrayList<Integer>();
//        list2.add(1);
//        list2.add(2);
//        list2.add(3);
        List<String> list2 = new ArrayList<String>();
        list2.add("1");
        list2.add("2");
        list2.add("3");

        List list3 = duplicateRemoval(list1,list2);
        System.out.println("list1:"+list1);
        System.out.println("list2:"+list2);
        System.out.println("list3:"+list3);
    }

    /**
     * 使用set去重
     * @param list1
     * @param list2
     * @return
     */
    public static List duplicateRemoval(List list1,List list2){
        Set set1 = new HashSet(list1);
        Set set2 = new HashSet(list2);
//        System.out.println("set1:"+set1);
//        System.out.println("set2:"+set2);
        set1.addAll(set2);
        return new ArrayList(set1);
    }
}
