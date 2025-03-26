package arraylist.mid;

/**
 * 198. 打家劫舍
 *
 * @author huangchangjun
 * @date 2025-03-26
 */
public class 打家劫舍 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length + 100];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // dp数组记录对应位置下的最优情况，dp数组间隔即为单双数的最优情况
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
