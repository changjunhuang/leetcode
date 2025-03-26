package arraylist.mid;

/**
 * 152. 乘积最大子数组
 */
public class 乘积最大子序列 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int res = nums[0];
        // 包含了所有数相乘的情况
        // 奇数个负数的情况一
        for (int i = 0; i < nums.length; i++) {
            max *= nums[i];
            res = Math.max(res, max);
            if (max == 0) {
                max = 1;
            }
        }
        max = 1;
        //奇数个负数的情况二
        for (int i = nums.length - 1; i >= 0; i--) {
            max *= nums[i];
            res = Math.max(res, max);
            if (max == 0) {
                max = 1;
            }
        }
        return res;
    }

    //大值，小值
    public int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE;
        //一个保存最大的，一个保存最小的。
        int imax = 1;
        int imin = 1;
        for (int i = 0; i < nums.length; i++) {
            // 遇到负数时，交换最大最小值
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            // 如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}
