package arraylist.mid;

/**
 * 55. 跳跃游戏
 *
 * @author huangchangjun
 * @date 2025-06-20
 */
public class 跳跃游戏 {

    public static void main(String[] args) {
        跳跃游戏 solution = new 跳跃游戏();
        int[] nums = {2, 5, 0, 0};
        boolean result = solution.canJump(nums);
        System.out.println("Can jump to the end: " + result); // Expected output: true
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJump = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= maxJump) {
                maxJump = Math.max(maxJump, i + nums[i]);
                if (maxJump >= n - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
