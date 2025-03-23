package arraylist.easy;

/**
 * 169. 多数元素
 *
 * @author huangchangjun
 * @date 2025-03-24
 */
public class 多数元素 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;

        for (int num : nums) {
            // count为0意味着
            if (count == 0) {
                candidate = num;
            }
            int temp = (num == candidate) ? 1 : -1;
            count = count + temp;
        }
        return candidate;
    }
}
