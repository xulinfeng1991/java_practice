package xulinfeng.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xujiahong on 2018/1/26.
 * ======================功能列表======================
 * 测试循环中删除元素
 */
public class ListRemoveTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        System.out.println(list);

        Iterator it = list.iterator();
        while (it.hasNext()){
            Integer num = (Integer) it.next();
            if(num==2){
                it.remove();
//                list.remove(num);//ConcurrentModificationException
            }
        }

        //传统for循环不可取
//        for(int i=0;i<list.size();i++){
//            Integer num = list.get(i);
//            if(num==2){
//                list.remove(num);//由于随时改变list的长度，所以造成部分元素没有移除
//            }
//        }

        //直接抛异常
//        for(Integer num : list){
//            if(num==2){
//                list.remove(num);//ConcurrentModificationException
//            }
//        }




        System.out.println(list);
    }
}
