package com.multithread.wait;

import com.multithread.common.LoopTaskThread;
import com.multithread.common.ThreadManager;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by xujiahong on 2017/7/10.
 * ======================功能列表======================
 * <p>wait()</p>
 */
public class WaitTest {


    /**
     * 网上讲解 wait,notify,notifyAll 的知识点，全是生产者消费者模式。
     * 此处演示另一个业务场景：多个生产者线程，轮流向队列中添加5个自己的产品，添加到maxSize就停止所有线程。
     */
    public static void main(String[] args) throws InterruptedException {
        int maxSize = 50;
        Queue<Integer> queue = new LinkedList<Integer>();
        /*
        ProducerThread 没有同步锁，出现了并发，最终队列长度容易大于maxSize
         */
//        ProducerThread t1 = new ProducerThread(queue, maxSize, "t1");
//        ProducerThread t2 = new ProducerThread(queue, maxSize, "t2");
//        ProducerThread t3 = new ProducerThread(queue, maxSize, "t3");
//        t1.start();
//        t2.start();
//        t3.start();
//        t1.join();
//        t2.join();
//        t3.join();
//        System.out.println("队列的长度"+queue.size());
        /*
        SynProducerThread 使用了同步锁，能处理并发时判断 queue.size()，保证添加准确个数的产品
        但是线程的执行没有做到“轮流”
         */
//        SynProducerThread s1 = new SynProducerThread(queue, maxSize, "s1");
//        SynProducerThread s2 = new SynProducerThread(queue, maxSize, "s2");
//        SynProducerThread s3 = new SynProducerThread(queue, maxSize, "s3");
//        s1.start();
//        s2.start();
//        s3.start();
//        s1.join();
//        s2.join();
//        s3.join();
//        System.out.println("队列的长度" + queue.size());

        /*
        自定义工具类显威力
         */
        ThreadManager manager = new ThreadManager();
        MyProduceThread t1 = new MyProduceThread("t1",manager,queue);
        MyProduceThread t2 = new MyProduceThread("t2",manager,queue);
        MyProduceThread t3 = new MyProduceThread("t3",manager,queue);
        manager.regist(t1).regist(t2).regist(t3);
        manager.setCount(10);
        manager.start();

    }
}

class MyProduceThread extends LoopTaskThread {
    private Queue<Integer> queue;

    public MyProduceThread(String name, ThreadManager manager, Queue<Integer> queue) {
        super(name, manager);
        this.queue = queue;
    }

    @Override
    synchronized public void exeTask() {
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int num = random.nextInt();
            queue.add(num);
            System.out.println(this.name + "正在生产产品：" + i + "_" + num + "【" + queue.size() + "】");
        }
        System.out.println("");
    }

    @Override
    public void run() {
        try {
            this.runTotal();//管理器策略：多个线程轮流执行某项任务，总共执行 count 次。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


/**
 * 没有加同步锁
 */
class ProducerThread extends Thread {
    private String name;
    private Queue<Integer> queue;
    private int maxSize;

    public ProducerThread(Queue<Integer> queue, int maxSize, String name) {
        super(name);
        this.name = name;
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (queue.size() < maxSize) {
            for (int i = 0; i < 5; i++) {
                Random random = new Random();
                int num = random.nextInt();
                queue.add(num);
                System.out.println(this.name + "正在生产产品：" + i + "_" + num + "【" + queue.size() + "】");
            }
            System.out.println("");
        }
    }
}

/**
 * 同步锁
 */
class SynProducerThread extends Thread {
    private String name;
    private Queue<Integer> queue;
    private int maxSize;

    public SynProducerThread(Queue<Integer> queue, int maxSize, String name) {
        super(name);
        this.name = name;
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        synchronized (queue) {
            System.out.println(name + "【进入同步块】");
            while (queue.size() < maxSize) {
                System.out.println(name + "进入循环");
                queue.notifyAll();//如果不加等待和唤醒，逻辑会被单个线程一次处理完
                for (int i = 0; i < 5; i++) {
                    Random random = new Random();
                    int num = random.nextInt();
                    queue.add(num);
                    System.out.println(this.name + "正在生产产品：" + i + "_" + num + "【" + queue.size() + "】");
                }
                try {
                    if (queue.size() < maxSize) {
                        System.out.println(name + " thread is wait.");
                        System.out.println("");
                        queue.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("");
            }
        }
        System.out.println(name + " thread is end.");
    }
}