package com.multithread.join;
/**
 * <p>join()应用场景</p>
 * 在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将在子线程之前结束。
 * 但是如果主线程需要用到子线程的处理结果，就要用到join()方法了。
 * <p>自己的描述</p>
 * 线程一旦开启后，都是异步执行的。无论是“并列的线程”还是“嵌套的线程”，执行结束的顺序都是未知的。
 * 如果需要线程xxx的处理结果，主线程中就调用xxx.join()即可，主线程就会在此处阻塞，直到xxx执行完成。
 */

/**
 * Created by xujiahong on 2017/7/6.
 * ======================功能列表======================
 * 学习 join()
 * 什么情况下会产生InterruptedException ？
 */

public class JoinTest {

    public static void test1() throws InterruptedException {
        System.out.println("test1**************************************************");
        Print5Thread pt5a = new Print5Thread("A");
        Print5Thread pt5b = new Print5Thread("B");
        pt5a.start();
        pt5b.start();
        pt5a.join();
        pt5b.join();
    }

    public static void test2() throws InterruptedException {
        System.out.println("test2**************************************************");
        Print8Thread pt8 = new Print8Thread("A");
        pt8.start();
        pt8.join();
    }

    public static void test3() throws InterruptedException {
        System.out.println("test3**************************************************");
        Goods g = new Goods();
        Add5Thread add5 = new Add5Thread("A",g);
        add5.start();
        add5.join();
        System.out.println("获取到的商品库存为："+g.getNum());//此处需要用到商品库存，所以前面必须调用join()
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
//        test1();
//        test2();
        test3();
        System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
    }
}
