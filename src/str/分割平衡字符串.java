package str;

public class 分割平衡字符串 {
    public int balancedStringSplit(String s) {
        int result = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                l++;
            }
            if (s.charAt(i) == 'L') {
                r++;
            }
            if (l++ == r++) {
                result++;
            }
        }
        return result;
    }
}
