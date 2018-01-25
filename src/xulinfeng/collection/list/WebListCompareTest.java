package xulinfeng.collection.list;

import java.util.*;

/**
 * Created by xujiahong on 2018/1/24.
 * ======================功能列表======================
 * 代码源于网络（对比ArrayList和LinkedList的插入、随机读取效率、删除的效率）
 * http://blog.csdn.net/guoweimelon/article/details/50800973
 * 【结论】
 * (01) 对于需要快速插入，删除元素，应该使用LinkedList。
 * (02) 对于需要快速随机访问元素，应该使用ArrayList。
 */
public class WebListCompareTest {
    private static final int COUNT = 100000;
    private static LinkedList linkedList = new LinkedList();
    private static ArrayList arrayList = new ArrayList();
    private static Vector vector = new Vector();
    private static Stack stack = new Stack();

    public static void main(String[] args) {
        // 换行符
        System.out.println();
        // 插入
        insertByPosition(stack);
        insertByPosition(vector);
        insertByPosition(linkedList);
        insertByPosition(arrayList);
        // 换行符
        System.out.println();
        // 随机读取
        readByPosition(stack);
        readByPosition(vector);
        readByPosition(linkedList);
        readByPosition(arrayList);
        // 换行符
        System.out.println();
        // 删除
        deleteByPosition(stack);
        deleteByPosition(vector);
        deleteByPosition(linkedList);
        deleteByPosition(arrayList);
    }

    // 获取list的名称
    private static String getListName(List list) {
        if (list instanceof LinkedList) {
            return "LinkedList";
        } else if (list instanceof ArrayList) {
            return "ArrayList";
        } else if (list instanceof Stack) {
            return "Stack";
        } else if (list instanceof Vector) {
            return "Vector";
        } else {
            return "List";
        }
    }

    // 向list的指定位置插入COUNT个元素，并统计时间
    private static void insertByPosition(List list) {
        long startTime = System.currentTimeMillis();
        // 向list的位置0插入COUNT个数
        for (int i = 0; i < COUNT; i++)
            list.add(0, i);
//             list.add(i);//这叫正常添加，不是插入
        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : insert " + COUNT + " elements into the 1st position use time：" +
                interval + " ms");
    }

    // 从list的指定位置删除COUNT个元素，并统计时间
    private static void deleteByPosition(List list) {
        long startTime = System.currentTimeMillis();
        // 删除list第一个位置元素
        for (int i = 0; i < COUNT; i++)
            list.remove(0);
        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : delete " + COUNT + " elements from the 1st position use time：" +
                interval + " ms");
    }

    // 根据position，不断从list中读取元素，并统计时间
    private static void readByPosition(List list) {
        long startTime = System.currentTimeMillis();
        // 读取list元素
        for (int i = 0; i < COUNT; i++)
            list.get(i);
        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : read " + COUNT + " elements by position use time：" + interval + " " +
                "ms");
    }
}
