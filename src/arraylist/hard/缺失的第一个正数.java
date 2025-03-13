package arraylist.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * 41. 缺失的第一个正数
 * @author huangchangjun
 * @date 2025-03-14
 */
public class 缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        // 使用数组来作为映射，类似于桶排序
        for (int i = 1; i <= len ; i++) {
            if (!hashSet.contains(i)){
                return i;
            }
        }

        return len + 1;
    }
}
