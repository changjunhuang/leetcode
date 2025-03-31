package str;

/**
 * 344. 反转字符串
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        char c;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            c = s[j];
            s[j] = s[i];
            s[i] = c;
        }
    }
}
