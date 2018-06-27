package xulinfeng.exception;

/**
 * Created by xujiahong on 2018/2/9.
 * ======================功能列表======================
 */
public class TryCatchFinallySeq {
    public static void main(String[] args) {
        int n = getNum();
        System.out.println(n);
    }

    /**
     * 结论：finally中的return会覆盖catch中的return结果
     * @return
     */
    public static int getNum(){
        int n=9;
        try {
            n = 9/9;
            return n;
        }catch (Exception e){
            n = 2;
            return n;
        }finally {
            System.out.println(n);
            n = 3;
            return n;
        }
    }
}
