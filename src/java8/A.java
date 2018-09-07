package java8;

/**
 * description
 *
 * @author xujiahong
 * @date 2018/8/13
 */
@FunctionalInterface //添加此注解后，接口中只能有一个抽象方法。
public interface A {

    void call();

    default void fun() {
        System.out.println("我是接口的默认方法1中的代码");
    }

    default void fun2() {
        System.out.println("我是接口的默认方法2中的代码");
    }
}
