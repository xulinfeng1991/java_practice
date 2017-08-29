package xulinfeng.other.callback;

/**
 * Created by xujiahong on 2017/7/18.
 * ======================功能列表======================
 * <p>概念描述</p>
 * 所谓的回调，就是程序员A写了一段程序（程序a），其中预留有回调函数接口，并封装好了该程序。
 * 程序员B要让a调用自己的程序b中的一个方法，于是，他通过a中的接口回调自己b中的方法。
 * <p>核心思想</p>
 * 面向接口或抽象类编程，未来通过实现来扩展功能
 * <p>应用场景不明</p>
 */
public class CallBackTest2 {
}

/**
 * 程序员A写了一段程序（程序a），其中预留有回调函数接口，并封装好了该程序。
 */
class A{
    private CallBack callBack;

    //。。。程序a的其他方法

    public void setCallBack(CallBack callBack){
        this.callBack = callBack;
    }

    //预留的回调函数接口
    public void callback(){
        callBack.execute();
    }
}

class B{
    public static void main(String[] args) {
        A a = new A();
        a.setCallBack(new CallBack() {
            @Override
            public void execute() {
                System.out.println("自定义代码片段");
            }
        });
        a.callback();
    }
}