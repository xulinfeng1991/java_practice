package xulinfeng.multithread.yield;

import xulinfeng.multithread.common.PrintNumThread;

/**
 * Created by xujiahong on 2017/7/7.
 * ======================功能列表======================
 * <p>yield()</p>
 * yield()目的是让出CUP调度时间，让当前运行线程回到可运行状态，以允许具有相同（或更高）优先级的其他线程获得运行机会。
 * 但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
 * yield()方法对应了如下操作：先检测当前是否有相同优先级的线程处于同可运行状态。
 * 如有，则把 CPU 的占有权交给此线程，否则，继续运行原来的线程。所以yield()方法称为“退让”，它把运行机会让给了同等优先级的其他线程
 * <p>yield() VS sleep()</p>
 * sleep()使当前线程进入停滞状态，所以执行sleep()的线程在指定的时间内肯定不会被执行；
 * sleep 方法允许较低优先级的线程获得运行机会，但 yield()方法执行时，当前线程仍处在可运行状态，
 * 所以，不可能让出较低优先级的线程些时获得 CPU 占有权。在一个运行系统中，
 * 如果较高优先级的线程没有调用 sleep 方法，又没有受到 I\O 阻塞，
 * 那么，较低优先级线程只能等待所有较高优先级的线程运行结束，才有机会运行。
 */
public class YieldTest {
    public static void main(String[] args) throws InterruptedException {
        int num = 100;
        System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
        Thread a = new Thread(new PrintNumThread("a", num));
        Thread b = new Thread(new PrintNumThread("b", num));
        a.setPriority(Thread.MAX_PRIORITY);
        b.setPriority(Thread.MIN_PRIORITY);
        a.start();
        b.start();
        a.yield();//此处换成a.yield()效果并不明显，因为a的优先级高，执行yield()进入到“可执行状态”后，很可能马上又被执行。
//        Thread.currentThread().sleep(1000);
//        for (int i = 0; i < num; i++) {
//            System.out.println(Thread.currentThread().getName() + "主线程正在打印数字：" + i);
//        }
        System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
    }
}
