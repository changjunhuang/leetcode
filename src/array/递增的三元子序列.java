package array;

public class 递增的三元子序列 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int big = Integer.MAX_VALUE;
        int small = Integer.MAX_VALUE;
        for (int i : nums) {
            // 通过if的结构保证递增！
            if (i <= small) {
                small = i;
            }
            // 走到这一步说明这个值大于前面的值(i>small)
            else if (i <= big) {
                big = i;
            }
            // 走到这一步说明这个值大于前面的两个值（i>big>small）
            else {
                return true;
            }
        }
        return false;
    }
}
