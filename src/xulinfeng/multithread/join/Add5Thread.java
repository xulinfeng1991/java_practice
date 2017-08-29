package xulinfeng.multithread.join;

/**
 * Created by xujiahong on 2017/7/7.
 * ======================功能列表======================
 * 将num+5的方法
 * sleep()模拟了线程执行的时间消耗
 * Goods模拟了实际业务，如商品入库（多线程下需要一致性）
 */
class Goods {
    private String name;
    private int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

public class Add5Thread extends Thread {

    private String name;
    private Goods g;

    public Add5Thread(String name, Goods g) {
        super(name);
        this.name = name;
        this.g = g;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "线程运行步骤：" + i);
            try {
                sleep((int)(Math.random() * 100));
                g.setNum(g.getNum()+1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }
}
