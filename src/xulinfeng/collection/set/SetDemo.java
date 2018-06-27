package xulinfeng.collection.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by xujiahong on 2018/1/18.
 * ======================功能列表======================
 */
public class SetDemo {

    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("Bernadine");
        set.add("Elizabeth");
        set.add("Gene");
        set.add("Elizabeth");
        set.add("Clara");
        System.out.println(set);
        Set sortedSet = new TreeSet(set);
        System.out.println(sortedSet);
    }
}
