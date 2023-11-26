package interview.会小二;

import java.util.*;

/**
 * @author huangchangjun
 * @date
 */
public class XiaoerTest {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 7, 8, 10};
        getTwoNumber(nums, 15);
    }


    /**
     * @param nums 初始数组
     * @param key  目标数字
     * @return
     */
    public static void getTwoNumber(int[] nums, int key) {
        if (nums == null) {
            return;
        }

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            int temp = key - num;
            if (set.contains(temp)) {
                list.add(num);
                list.add(temp);
                break;
            }
        }

        System.out.println(list.toString());
    }



}
