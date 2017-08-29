package xulinfeng.multithread.join;

/**
 * Created by xujiahong on 2017/7/6.
 * ======================功能列表======================
 * 打印8个数字的线程，sleep()模拟了线程执行的时间消耗
 * Print5Thread线程 join
 */
public class Print8Thread extends Thread {
    private String name;

    public Print8Thread(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        Print5Thread pt = new Print5Thread("inner");
        pt.start();
        try {
            pt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(name + "线程运行步骤：" + i);
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }
}