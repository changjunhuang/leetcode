package dp;

/**
 * 70. 爬楼梯
 *
 * @author huangchangjun
 * @date 2025-03-10
 */
public class 爬楼梯 {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int left = 1;
        int right = 2;
        for (int z = 3; z <= n; z++) {
            right = left + right;
            left = right - left;
        }
        return right;
    }
}
