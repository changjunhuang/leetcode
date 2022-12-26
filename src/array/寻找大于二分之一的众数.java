package array;

/**
 * 寻找大于1/2 的众数
 */
public class 寻找大于二分之一的众数 {
    public int majorityElement(int[] nums) {
        //位运算法,统计每个数字每一位0，1出现的次数，如果某一位1出现的次数多则该位为1，0同理；
        //最后按为统计出来的数就是众数
        int res = 0, len = nums.length;
        for (int i = 0; i < 32; i++) {
            int ones = 0, zero = 0;
            for (int j = 0; j < len; j++) {
                if (ones > len / 2 || zero > len / 2) {
                    break;
                }
                if ((nums[j] & (1 << i)) != 0) {
                    ones++;
                } else {
                    zero++;
                }
            }
            if (ones > zero) {
                res = res | (1 << i);
            }
        }
        return res;
    }

    public int majorityElement2(int[] nums) {
        //摩尔投票法,先假设第一个数过半数并设cnt=1；遍历后面的数如果相同则cnt+1，
        // 不同则减一，当cnt为0时则更换新的数字为候选数（成立前提：有出现次数大于n/2的数存在）
        int res = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                res = nums[i];
                cnt++;
            } else {
                res = res == nums[i] ? cnt++ : cnt--;
            }
        }
        return res;
    }

}
