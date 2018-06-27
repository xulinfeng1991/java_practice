package xulinfeng.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xujiahong on 2017/12/14.
 * ======================功能列表======================
 * 红色球号码区由1-33共三十三个号码组成，蓝色球号码区由1-16共十六个号码组成。
 * 投注时选择6个红色球号码和1个蓝色球号码组成一注进行单式投注，每注金额人民币2元。
 *
 * 我的幸运号：【01，08，14，18，27，33】【06】
 * 每次买一个幸运号，一个随机号
 */
public class ShuangSeQiu {


    public static void main(String[] args) {
        getRandomNum();
    }

    public static void getRandomNum(){
        List<Integer> redBall = new ArrayList<Integer>();
        for(int i=1;i<=33;i++){
            redBall.add(i);
        }
        //获取号码
        Random random = new Random();
        System.out.print("红球：");
        for(int i=0;i<6;i++){
            int redIndex = random.nextInt(redBall.size());
            System.out.print(redBall.get(redIndex)+" ");
            redBall.remove(redIndex);
        }
        System.out.print("\n蓝球：");
        System.out.print(random.nextInt(16)+1);

    }



}
