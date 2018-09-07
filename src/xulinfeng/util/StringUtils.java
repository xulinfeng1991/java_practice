package xulinfeng.util;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author xujiahong
 * @date 2018/9/4
 */
public class StringUtils {


    /**
     * 判断两个字符串列表是否相同
     *
     * @param stringList1
     * @param stringList2
     * @return
     */
    public static boolean stringListEquals(List<String> stringList1, List<String> stringList2) {
        return stringList1.equals(stringList2);
    }

    public static void main(String[] args) {
        List<String> stringList1 = new ArrayList<>();
        stringList1.add("xujiahong");
        stringList1.add("zpj");
        List<String> stringList2 = new ArrayList<>();
        stringList2.add("xujiahong");
        stringList2.add("zpj");
        System.out.println(stringListEquals(stringList1,stringList2));
    }
}
