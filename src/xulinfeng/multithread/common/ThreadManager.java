package xulinfeng.multithread.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xujiahong on 2017/7/12.
 * ======================功能列表======================
 * 自定义的线程管理工具，方便管理【轮流执行任务的线程】。配合 LoopTaskThread 类的子类使用
 * 适用于以下两种业务场景：（1）多个线程轮流执行某项任务，每个线程各执行 count 次；（2）多个线程轮流执行某项任务，总共执行 count 次。
 */
public class ThreadManager {
    /**
     * 线程名称数组
     */
    private List<LoopTaskThread> loopTaskThreads = new ArrayList<LoopTaskThread>();
    /**
     * 当前线程索引
     */
    private int index = 0;
    /**
     * 循环计数器
     */
    private int count = 0;


    /**
     * [辅助字段]是否是调试模式
     */
    private boolean isDebugModel = false;
    /**
     * [辅助字段]效率标识（检测自动安排线程任务时的错误匹配次数）
     */
    private int wrongNum = 0;

    /**
     * 根据线程名称返回索引
     *
     * @param threadName
     * @return
     */
    public int indexOf(String threadName) {
        if (loopTaskThreads.isEmpty()) {
            return -1;
        }
        if (threadName == null || threadName.equals("")) {
            return -1;
        }
        for (int i = 0; i < loopTaskThreads.size(); i++) {
            if (threadName.equals(loopTaskThreads.get(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回对应索引的线程名称
     *
     * @param index
     * @return
     */
    public String getThreadName(int index) {
        if (loopTaskThreads.isEmpty()) {
            return null;
        }
        if (index >= 0 && index < loopTaskThreads.size()) {
            return loopTaskThreads.get(index).getName();
        }
        return null;
    }

    /**
     * 返回当前线程名称
     * @return
     */
    public String getCurrentThreadName(){
        return getThreadName(index);
    }

    /**
     * 改变当前索引为下一位置
     */
    public void next() {
        if (loopTaskThreads.isEmpty()) {
            return;
        }
        if (index == loopTaskThreads.size() - 1) {
            index = 0;
        } else {
            index++;
        }
    }

    /**
     * 注册线程
     * @param thread
     */
    public ThreadManager regist(LoopTaskThread thread){
        if(thread!=null){
            loopTaskThreads.add(thread);
        }
        return this;
    }

    /**
     * 无效线程获得同步锁次数+1（如果LoopTaskThread中wait(),notifyAll()的策略有问题，此参数就容易过大，表明自动安排线程效率低下）
     */
    public void addWrongNum(){
        this.wrongNum++;
    }

    public void start() throws InterruptedException {
        if(!loopTaskThreads.isEmpty()){
            long startTime = System.currentTimeMillis();
            int originalCount = count;
            for(LoopTaskThread t : loopTaskThreads){
                t.start();
            }
            for(LoopTaskThread t : loopTaskThreads){
                t.join();
            }
            System.out.println("");
            System.out.print("开启线程数："+loopTaskThreads.size()+"；执行次数："+originalCount+"；无效线程占用同步锁次数："+this.wrongNum);
            System.out.println("；执行时间："+(System.currentTimeMillis()-startTime)+" 毫秒");
        }
    }

    //getter and setter
    public List<LoopTaskThread> getLoopTaskThreads() {
        return loopTaskThreads;
    }

    public void setLoopTaskThreads(List<LoopTaskThread> loopTaskThreads) {
        this.loopTaskThreads = loopTaskThreads;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isDebugModel() {
        return isDebugModel;
    }

    public void setDebugModel(boolean debugModel) {
        isDebugModel = debugModel;
    }

    public int getWrongNum() {
        return wrongNum;
    }

    public void setWrongNum(int wrongNum) {
        this.wrongNum = wrongNum;
    }
}
