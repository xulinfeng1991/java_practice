package com.multithread.join;

/**
 * Created by xujiahong on 2017/7/6.
 * 打印5个数字的线程，sleep()模拟了线程执行的时间消耗
 */
public class Print5Thread extends Thread{
    private String name;
    public Print5Thread(String name) {
        super(name);
        this.name=name;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
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
