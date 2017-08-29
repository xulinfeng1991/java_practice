package xulinfeng.multithread.common;

/**
 * Created by xujiahong on 2017/7/7.
 * ======================功能列表======================
 */
public class PrintNumThread implements Runnable {
    private String name;
    private int num;
    private final int minNum = 10;

    public PrintNumThread(String name,int num) {
        this.name = name;
        this.num = num>minNum?num:minNum;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            System.out.println(name + "数字打印线程正在运行：" + i);
        }
    }
}
