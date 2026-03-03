package dp.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 279. 完全平方数
 *
 * @author huangchangjun
 * @date 2025-06-25
 */
public class 完全平方数 {
    public static void main(String[] args) {
        int n = 12;
        int result = numSquares(n);
        System.out.println("The least number of perfect square numbers for " + n + " is: " + result);
    }

    public static int numSquares(int n) {
        List<Integer> squareList = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squareList.add(i * i);
        }
        squareList = squareList.stream().sorted((Integer::compareTo)).toList();
        int result = 0;
        int total = 0;
        for (int j = squareList.size() - 1; j >= 0; j--) {
            total = total + squareList.get(j);
            if (total == n) {
                result++;
                break;
            }
            if (total > n) {
                break;
            }
            result++;
        }
        return result;
    }
}
