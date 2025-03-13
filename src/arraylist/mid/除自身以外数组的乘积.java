package arraylist.mid;

/**
 * 238. 除自身以外数组的乘积
 *
 * @author huangchangjun
 * @date 2025-03-10
 */
public class 除自身以外数组的乘积 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ints = productExceptSelf(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] goal = new int[nums.length];
        // 乘积等于左边乘积*右边数乘积
        goal[0] = 1;
        // 先计算左边乘积
        for (int i = 1; i < nums.length; i++) {
            goal[i] = goal[i - 1] * nums[i - 1];
        }
        int k = 1;
        // 再计算右边乘积
        for (int i = nums.length - 1; i >= 0; i--) {
            // 乘积等于右边数乘积*左边乘积
            goal[i] = k * goal[i];
            // 右边乘积
            k *= nums[i];
        }
        return goal;
    }
}
