package bin;

/**
 * 191. 位1的个数
 */
public class 位1的个数 {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        int totalNum = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                totalNum++;
            }

            //  无符号右移
            n = n >>> 1;
        }
        return totalNum;
    }
}
