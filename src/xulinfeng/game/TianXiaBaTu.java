package xulinfeng.game;

/**
 * Created by xujiahong on 2018/4/9.
 * ======================功能列表======================
 */
public class TianXiaBaTu {
    public static void main(String[] args) {
        int num=0;
        for(int i=2;i<=50;i++){
            System.out.print("[");
            if(i<10){
                System.out.print("0");
            }
            num = (100*(i-1));
            String s = "0000000"+num;
            s = s.substring(s.length()-7,s.length());
            System.out.println(i+","+s+"]");
        }
    }
}
