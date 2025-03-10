package arraylist.mid;

/**
 * 53. 最大子数组和
 *
 * @author huangchangjun
 * @date 2025-03-10
 */
public class 最大子数组和 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        // sum 记录最大值 n记录当前位置的值
        int sum = nums[0];
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (n > 0) {
                // 如果n大于0，那么n就有意义，继续累加
                n = n + nums[i];
            } else {
                // 如果n小于等于0，那么n就没有意义了，直接取当前位置的值
                n = nums[i];
            }
            if (sum < n) {
                sum = n;
            }
        }
        return sum;
    }
}
