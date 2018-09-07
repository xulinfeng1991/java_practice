package xulinfeng.temp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * Created by xujiahong on 2017/12/5.
 * ======================功能列表======================
 */
public class Temp1 {

    public static void main(String[] args) {
        String str1 = "甲、乙、丙、丁、戊、己、庚、辛、壬、癸";
        String str2 = "子、丑、寅、卯、辰、巳、午、未、申、酉、戌、亥";
        String[] tiangan = str1.split("、");
        String[] dizhi = str2.split("、");
    }

}
