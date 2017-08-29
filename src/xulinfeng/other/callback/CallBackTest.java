package xulinfeng.other.callback;

/**
 * Created by xujiahong on 2017/7/17.
 * ======================功能列表======================
 * 回调函数的一种应用场景（计算方法运行时间）
 * 代码来源：http://kidult.iteye.com/blog/148982
 */
public class CallBackTest {
    /**
     * 一个用来被测试的方法，进行了一个比较耗时的循环
     */
    public static void testMethod() {
        for (int i = 0; i < 100000000; i++) {

        }
    }

    /**
     * 一个简单的测试方法执行时间的方法
     */
    public void testTime() {
        long begin = System.currentTimeMillis(); //测试起始时间
        testMethod(); //测试方法
        long end = System.currentTimeMillis(); //测试结束时间
        System.out.println("[use time]:" + (end - begin)); //打印使用时间
    }

    public static void main(String[] args) {
        CallBackTest test = new CallBackTest();
        test.testTime();
    }
}


class Tools {

    /**
     * 测试函数使用时间，通过定义CallBack接口的execute方法
     *
     * @param callBack
     */
    public void testTime(CallBack callBack) {
        long begin = System.currentTimeMillis(); //测试起始时间
        callBack.execute(); ///进行回调操作
        long end = System.currentTimeMillis(); //测试结束时间
        System.out.println("[use time]:" + (end - begin)); //打印使用时间
    }

    public static void main(String[] args) {
        Tools tool = new Tools();
        tool.testTime(new CallBack() {
            //定义execute方法
            public void execute() {
                //这里可以加放一个或多个要测试运行时间的方法
                CallBackTest.testMethod();
            }
        });
    }

}