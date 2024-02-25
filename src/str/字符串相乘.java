package str;

/**
 * 43. 字符串相乘
 * TODO 大数的情况下测试用例通不过，会变成负值
 */
public class 字符串相乘 {
    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "456";

        System.out.println(multiply(str1, str2));
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
