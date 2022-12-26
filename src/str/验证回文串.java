package str;

/**
 * 125. 验证回文串
 * 题目：只验证数字和小写字母，其他符号不算
 */
public class 验证回文串 {
    //原地算法
    public boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        int cnt = 0, j = 0;
        //将其他的符号排除，并转换大小写，最后只剩一串小写字符串
        for (int i = 0; i < cs.length; i++) {
            if (('0' <= cs[i] && cs[i] <= '9') || ('a' <= cs[i] && cs[i] <= 'z')) {
                cs[cnt++] = cs[i];
            } else if ('A' <= cs[i] && cs[i] <= 'Z') {
                cs[cnt++] = (char) (cs[i] - 'A' + 'a');
            }
        }
        cnt--;
        while (j < cnt) {
            if (cs[j++] != cs[cnt--]) {
                return false;
            }
        }
        return true;
    }

    //双指针法
    public boolean isPalindrome2(String s) {
        if (s.length() <= 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isAlnum(s.charAt(left))) {
                left++;
            }
            while (left < right && !isAlnum(s.charAt(right))) {
                right--;
            }
            if (toLower(s.charAt(left++)) != toLower(s.charAt(right--))) {
                return false;
            }
        }
        return true;
    }

    // 判断是否是字母或者是数字
    private boolean isAlnum(char c) {
        if (('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
            return true;
        }
        return false;
    }

    //将大写字母转换成小写字母
    private char toLower(char c) {
        if ('A' <= c && c <= 'Z') {
            c = (char) (c - 'A' + 'a');
        }
        return c;
    }
}
