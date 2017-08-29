package xulinfeng.other.bit;

/**
 * Created by xujiahong on 2017/7/24.
 * ======================功能列表======================
 *
 */
public class BitTest {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(changeStatus2(0)));
        System.out.println(Integer.toBinaryString(changeStatus2(0)).length());
    }

    //0，1状态互换
    public static int changeStatus1(int num){
        return 1^num;
    }

    //0，1状态互换
    public static int changeStatus2(int num){
        return ~num;
    }


}
