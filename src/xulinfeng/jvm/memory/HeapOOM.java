package xulinfeng.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xujiahong on 2017/12/4.
 * ======================功能列表======================
 * 测试 OutOfMemoryError
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject {
        int i;
        String s;
    }

    public static void main(String[] args) {
        System.out.println("aa");
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true){
            //为什么是30M，明明设置了20M
            list.add(new OOMObject());//Heap dump file created [32262548 bytes in 0.136 secs]
            // TODO 学习查看内存快照文件
        }
    }

}
