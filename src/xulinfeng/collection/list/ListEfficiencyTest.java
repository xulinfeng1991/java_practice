package xulinfeng.collection.list;

import java.util.*;

/**
 * list相关的性能测试
 * Created by xujiahong on 2018/1/23.
 * ======================功能列表======================
 * 新增花费时间
 * 删除花费时间
 * 查询花费时间
 * 传统for循环遍历花费时间
 * 迭代器Iterator遍历花费时间
 * foreach遍历花费时间
 */
public class ListEfficiencyTest {

    private static Map<String, Long> mapA = new TreeMap();
    private static Map<String, Long> mapL = new TreeMap();

    /*
    100000数据下测试
    arrayList***********************
    插入、删除慢
    随机访问、遍历快
    add操作花费时间：8（ms）
    select操作花费时间：8（ms）
    forloop操作花费时间：3（ms）
    iterator操作花费时间：13（ms）
    foreach操作花费时间：5（ms）
    deleteObj操作花费时间：1388（ms）
    addByIndex操作花费时间：1399（ms）
    deleteByIndex操作花费时间：1195（ms）

    linkedList***********************
    插入、删除快
    随机访问、遍历慢
    add操作花费时间：49（ms）
    select操作花费时间：11403（ms）
    forloop操作花费时间：5164（ms）
    iterator操作花费时间：12（ms）
    foreach操作花费时间：5（ms）
    deleteObj操作花费时间：6（ms）
    addByIndex操作花费时间：7（ms）
    deleteByIndex操作花费时间：8（ms）
     */
    public static void main(String[] args) {

//        showTimeTable();

        List arrayList = new ArrayList();
        List linkedList = new LinkedList();

        System.out.println("arrayList***********************");
        printTime(arrayList, 100000);

        System.out.println("\nlinkedList***********************");
        printTime(linkedList, 100000);



    }

    /**
     * 对比多种长度下arrayList和linkedList的效率
     * 【实验结果】
     * add，差距不大
     * deleteObject，差距不大
     * addByIndex，ArrayList快
     * deleteByIndex，ArrayList快
     * select，ArrayList慢（？？）
     * 传统for循环，同select，ArrayList慢
     * foreach循环和iterator迭代器，差距不大
     */
    public static void showTimeTable() {

        //TODO 这个方法很尴尬，实验结果有问题
        List arrayList = new ArrayList();
        List linkedList = new LinkedList();
        for (int i = 2; i <= 19; i++) {
            printTime(arrayList, i * 500);
            printTime(linkedList, i * 500);
        }
        //遍历mapA
        Set<String> set = mapA.keySet();
        for (String s : set) {
            long a = mapA.get(s);
            long l = mapL.get(s);
            long times = 0;
            System.out.print(s + "-----");
            if (a >= l) {
                times = a / l;
                System.out.println("快" + times + "倍");
            } else {
                times = l / a;
                System.out.println("slow" + times + "倍");
            }
        }
    }

    /**
     * 打印某list所有操作花费的时间
     *
     * @param list
     * @param length
     */
    public static void printTime(List list, int length) {
        OperateType[] values = OperateType.values();
        for (OperateType value : values) {
            printTime(list, value, length);
        }
    }

    /**
     * 打印某list某种操作花费的时间
     *
     * @param list
     * @param type
     * @param length
     */
    public static void printTime(List list, OperateType type, int length) {
        long start = System.currentTimeMillis();
        switch (type) {
//            case add:
//                for (int i = 0; i < length; i++) {
//                    list.add("xujiahong");
//                }
//                break;
            case addByIndex:
                for (int i = 0; i < length; i++) {
                    list.add(0,"xujiahong");
                }
                break;
//            case deleteObj:
//                for (int i = 0; i < length; i++) {
//                    list.remove("xujiahong");
//                }
//                break;
            case deleteByIndex:
                for (int i = 0; i < length; i++) {
                    list.remove(0);
                }
                break;
            case select:
                for (int i = 0; i < length; i++) {
                    list.get(length / 2);
                }
                break;
            case forloop:
                for (int i = 0; i < list.size(); i++) {
                    Object o = list.get(i);
                    String s = o.toString();
                }
                break;
            case iterator:
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    Object o = iterator.next();
                    String s = o.toString();
                }
                break;
            case foreach:
                for (Object o : list) {
                    String s = o.toString();
                }
                break;
            default:
                break;
        }
        long end = System.currentTimeMillis();
        System.out.println(type + "操作花费时间：" + (end - start) + "（ms）");
//        if (list instanceof ArrayList) {
//            mapA.put("" + type + length, end - start);
//        } else if (list instanceof LinkedList) {
//            mapL.put("" + type + length, end - start);
//        }
    }


    enum OperateType {
        addByIndex, select, forloop, iterator, foreach, deleteByIndex;
        //add, addByIndex, select, forloop, iterator, foreach, deleteObj, deleteByIndex;
    }

}// class end
