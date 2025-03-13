package arraylist.mid;

/**
 * 189. 轮转数组
 *
 * @author huangchangjun
 * @date 2025-03-10
 */
public class 轮转数组 {
    public void rotate(int[] nums, int k) {
        if (k < 0) {
            return;
        }

        //取模，拿到绝对移动的长度
        k = k % nums.length;

        // 全部 逆序
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            reversal(nums, i, j);
        }
        // 对左边k位进行逆序
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            reversal(nums, i, j);
        }
        // 对右边 n-k位进行逆序
        for (int i = k, j = nums.length - 1; i < j; i++, j--) {
            reversal(nums, i, j);
        }
    }

    private static void reversal(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
