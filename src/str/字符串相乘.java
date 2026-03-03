package str;

import java.math.BigDecimal;

/**
 * 43. 字符串相乘
 * TODO 大数的情况下测试用例通不过，会变成负值
 */
public class 字符串相乘 {
    public static void main(String[] args) {
        String str1 = "6913259244";
        String str2 = "71103343";

        System.out.println(multiply2(str1, str2));
    }

    public static String multiply2(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        String longger = num1.length() >= num2.length() ? num1 : num2;
        String shorter = num1.length() < num2.length() ? num1 : num2;
        BigDecimal result = new BigDecimal(0);
        int key1 = 1;

        for (int i = shorter.length() - 1; i >= 0; i--) {
            if (i != shorter.length() - 1) {
                key1 = key1 * 10;
            }
            int key2 = 1;
            for (int j = longger.length() - 1; j >= 0; j--) {
                if (j != longger.length() - 1) {
                    key2 = key2 * 10;
                }
                BigDecimal temp = new BigDecimal((shorter.charAt(i) - 48) * key1).multiply(new BigDecimal((longger.charAt(j) - 48) * key2));
                result = result.add(temp);
            }
        }
        return result.toString();
    }

    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }

        int result = 0;
        // 十倍或百倍
        int num2Temp = 1;
        //  4 <- 5 <- 6
        for (int right = num2.length() - 1; right >= 0; right--) {
            int currentTotal = 0;
            // 十位百位需要分别乘10
            if (right != num2.length() - 1) {
                num2Temp = num2Temp * 10;
            }

            // 十倍或百倍
            int num1Temp = 1;
            //  1 2 3
            for (int i = num1.length() - 1; i >= 0; i--) {
                // 十位百位需要分别乘10
                if (i != num1.length() - 1) {
                    num1Temp = num1Temp * 10;
                }
                // 字符串字节ascll码计算成数字（-48）*十位百位
                currentTotal = currentTotal + (num1.charAt(i) - 48) * num1Temp * (num2.charAt(right) - 48) * num2Temp;
            }
            result = result + currentTotal;
        }
        return Integer.toString(result);
    }
}
