package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 1~10题
 *
 * @author xujiahong
 * @date 2018/9/5
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        twoSum(nums, target);
    }

    /**
     * (1)
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        //存放差值的list
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (list != null && list.size() > 0) {
                for (Integer one : list) {
                    if (num == one.intValue()) {
                        result[0] = list.indexOf(one);
                        result[1] = i;
                        System.out.println("[" + result[0] + "," + result[1] + "]");
                        return result;
                    }
                }
            }
            //num<target
            list.add(target - num);
        }
        return result;
    }

    /**
     * (7)
     * @param x
     * @return
     */
    public static int reverse(int x) {
        String str = (x>=0)?x+"":(-x)+"";
        String result = "";
        for(int i=str.length()-1;i>=0;i--){
            result += str.charAt(i);
        }
        result = (x>=0)?result:"-"+result;
        return Integer.parseInt(result);
    }


}
