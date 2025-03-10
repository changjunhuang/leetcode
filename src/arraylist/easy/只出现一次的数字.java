package arraylist.easy;

/**
 * 136. 只出现一次的数字
 * <p>
 * 交换律：a ^ b ^ c <=> a ^ c ^ b
 * 任何数于0异或为任何数 0 ^ n => n
 * 相同的数异或为0: n ^ n => 0
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int resl = 0;
        for (int i = 0; i < nums.length; i++) {
            resl = resl ^ nums[i];
        }
        return resl;
    }
}
