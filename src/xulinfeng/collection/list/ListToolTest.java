package xulinfeng.collection.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xujiahong on 2018/1/18.
 * ======================功能列表======================
 */
public class ListToolTest {

    public static void main(String[] args) {

        List list = new LinkedList();
        for(int i=0;i<9;i++){
            list.add("a"+i);
        }
        System.out.println(list);
        Collections.shuffle(list);//随机排列
        System.out.println("[shuffle]:"+list);
        Collections.reverse(list);//反转
        System.out.println("[reverse]:"+list);
        Collections.sort(list);//排序
        System.out.println("[sort]:"+list);
        System.out.println(Collections.binarySearch(list,"a5"));

    }
}


