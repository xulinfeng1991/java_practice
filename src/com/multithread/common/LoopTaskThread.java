package com.multithread.common;

/**
 * Created by xujiahong on 2017/7/13.
 * ======================功能列表======================
 * “轮流执行任务的线程”。
 * 适用于以下两种业务场景：（1）多个线程轮流执行某项任务，每个线程各执行 count 次；（2）多个线程轮流执行某项任务，总共执行 count 次。
 */
public abstract class LoopTaskThread extends Thread {
    protected String name;
    protected ThreadManager manager;

    public LoopTaskThread(String name, ThreadManager manager) {
        super(name);
        this.name = name;
        this.manager = manager;
    }
    
    private void logger(Object obj){
        if(manager.isDebugModel()){
            System.out.println(obj);
        }
    }

    /**
     * [日常效率评估]
     * 开启线程数：3；执行次数：90；无效线程占用同步锁次数：356；执行时间：12 毫秒
     * 开启线程数：3；执行次数：90；无效线程占用同步锁次数：357；执行时间：10 毫秒
     * 开启线程数：3；执行次数：90；无效线程占用同步锁次数：356；执行时间：9 毫秒
     */
    @Deprecated
    public void runSingleOld1() throws InterruptedException {
        int count = manager.getCount();
        synchronized (manager){
            logger(name+"线程第一次获得同步锁manager");
            while (count > 0) {
                if(name.equals(manager.getCurrentThreadName())){//是当前运行线程
                    this.exeTask();//执行任务
                    count--;
                    manager.next();
                    logger(name+"线程调用notifyAll()");
                    manager.notifyAll();//【】此处没有释放锁，还会继续执行-while-else，导致该线程又占用了同步锁一回合
                }else{
                    logger(name+"线程调用wait()释放了同步锁manager");
                    manager.addWrongNum();//效率测试参数
                    manager.wait();//不是当前线程，让出CPU并释放锁
                }
            }
        }
    }

    /**
     * （1）多个线程轮流执行某项任务，每个线程各执行 count 次；
     * 开启线程数：3；执行次数：90；无效线程占用同步锁次数：90；执行时间：9 毫秒
     * 开启线程数：3；执行次数：90；无效线程占用同步锁次数：89；执行时间：9 毫秒
     * 开启线程数：3；执行次数：90；无效线程占用同步锁次数：89；执行时间：10 毫秒
     * @throws InterruptedException
     */
    public void runSingle() throws InterruptedException {
        int count = manager.getCount();
        synchronized (manager){
            logger(name+"线程第一次获得同步锁manager");
            while (count > 0) {
                manager.notifyAll();//【】如果此处可以指定唤醒某个线程，效率更高
                if(name.equals(manager.getCurrentThreadName())){//是当前运行线程
                    this.exeTask();//执行任务
                    count--;
                    manager.next();
                    if(count!=0){//最后一次就不 wait() 了，让线程自然结束
                        manager.wait();
                    }
                }else{
                    manager.addWrongNum();//效率测试参数
                    manager.wait();//不是当前线程，让出CPU并释放锁
                }
            }
        }
    }

    @Deprecated
    public void runSingle1() throws InterruptedException {
        int count = manager.getCount();
        while (count > 0) {//明目暂不清楚 while synchronized 的顺序带来的影响
            synchronized (manager){
                logger(name+"线程第一次获得同步锁manager");
                manager.notifyAll();//【】如果此处可以指定唤醒某个线程，效率更高
                if(name.equals(manager.getCurrentThreadName())){//是当前运行线程
                    this.exeTask();//执行任务
                    count--;
                    manager.next();
                    if(count!=0){//最后一次就不 wait() 了，让线程自然结束
                        manager.wait();
                    }
                }else{
                    manager.addWrongNum();//效率测试参数
                    manager.wait();//不是当前线程，让出CPU并释放锁
                }
            }
        }
    }

    /**
     * （2）多个线程轮流执行某项任务，总共执行 count 次。
     * 开启线程数：3；执行次数：9；无效线程占用同步锁次数：11
     * 【优化后】开启线程数：3；执行次数：9；无效线程占用同步锁次数：2  （任务执行后最好还是 wait()）
     * @throws InterruptedException
     */
    public void runTotal() throws InterruptedException{
        synchronized (manager){
            logger(name+"线程第一次获得同步锁manager");
            while (manager.getCount() > 0) {
                manager.notifyAll();
                if(name.equals(manager.getCurrentThreadName())){//是当前运行线程
                    this.exeTask();//执行任务
                    manager.setCount(manager.getCount()-1);
                    manager.next();
                    if(manager.getCount()!=0){//最后一次就不 wait() 了，让线程自然结束
                        manager.wait();
                    }
                }else{
                    manager.addWrongNum();//效率测试参数
                    logger(name+"线程调用wait()释放了同步锁manager");
                    manager.wait();//不是当前线程，让出CPU并释放锁
                }
            }
        }
    }

    /**
     * 自定义执行任务的代码
     */
    public abstract void exeTask();

}
