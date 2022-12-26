package number;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 分析一位数 二位数 三位数 四位数 后得知;
 * 不会出现无限大的情况，要么在某几个数中无限循环，要么下降到1
 */
public class 快乐数 {

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    //  获取取平方后的下一个数
    private static int getNext(int n) {
        int total = 0;
        while (n != 0) {
            int temp = n % 10;
            n = n / 10;
            total += temp * temp;
        }
        return total;
    }
}
