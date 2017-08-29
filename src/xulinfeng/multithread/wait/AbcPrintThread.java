package xulinfeng.multithread.wait;

import xulinfeng.multithread.common.LoopTaskThread;
import xulinfeng.multithread.common.ThreadManager;

/**
 * Created by xujiahong on 2017/7/10.
 * ======================功能列表======================
 */
public class AbcPrintThread implements Runnable {

    private String name;
    private Object prev;
    private Object self;

    private AbcPrintThread(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        /*
        AbcPrintThread 使用网上的一种方法
         */
//        Object a = new Object();
//        Object b = new Object();
//        Object c = new Object();
//        AbcPrintThread pa = new AbcPrintThread("A", c, a);
//        AbcPrintThread pb = new AbcPrintThread("B", a, b);
//        AbcPrintThread pc = new AbcPrintThread("C", b, c);
//
//
//        new Thread(pa).start();
//        Thread.sleep(100);  //确保按顺序A、B、C执行
//        new Thread(pb).start();
//        Thread.sleep(100);
//        new Thread(pc).start();
//        Thread.sleep(100);

        /*
        使用家洪自定义工具类
         */
        ThreadManager manager = new ThreadManager();//manager作为同步锁参数传递给线程对象
        XjhAbcPrintThread a = new XjhAbcPrintThread("A",manager);
        XjhAbcPrintThread b = new XjhAbcPrintThread("B",manager);
        XjhAbcPrintThread c = new XjhAbcPrintThread("C",manager);
        manager.regist(a).regist(b).regist(c);
        manager.setDebugModel(false);
        manager.setCount(90);
        manager.start();
    }
}

class XjhAbcPrintThread extends LoopTaskThread {

    public XjhAbcPrintThread(String name, ThreadManager manager) {
        super(name,manager);
    }

    @Override
    public void exeTask() {//打印字母
        System.out.print(this.name);
    }

    @Override
    public void run() {
        try {
            this.runSingle();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}