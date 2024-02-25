package str.easy;

/**
 * 415. 字符串相加
 *
 * @author huangchangjun
 * @date2024/2/24
 */
public class 字符串相加 {
    public String addStrings(String num1, String num2) {
        // 123 + 456
        StringBuilder sb1 = new StringBuilder(num1).reverse();
        StringBuilder sb2 = new StringBuilder(num2).reverse();
        StringBuilder sb = new StringBuilder();

        int len1 = sb1.length();
        int len2 = sb2.length();
        int len;
        int num = 0;

        if (len1 >= len2) {
            len = len1;
            num = len1 - len2;
            while (num != 0) {
                sb2.append(0);
                num--;
            }
        } else {
            len = len2;
            num = len2 - len1;
            while (num != 0) {
                sb1.append(0);
                num--;
            }
        }

        int temp = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = (sb1.charAt(i) - 48) + (sb2.charAt(i) - 48) + temp;
            if (result >= 10) {
                temp = 1;
                result = result % 10;
                sb.append(result);
            } else {
                sb.append(result);
                temp = 0;
            }
        }

        if (temp == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
