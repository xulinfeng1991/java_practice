package java8;

/**
 * description
 *
 * @author xujiahong
 * @date 2018/8/13
 */
public class TestA {
    public static void main(String[] args) {
        A a = () -> System.out.println("this is a");
        a.call();
        a.fun();
    }
}
