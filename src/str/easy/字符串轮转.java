package str.easy;

/**
 * 面试题 01.09. 字符串轮转
 */
public class 字符串轮转 {
    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        //  s1 + s1 包含了所有旋转的情况；这时只用查找s2是否为 s1 + s1的字串即可确定s2是否是s1旋转得来
        return (s1 + s1).contains(s2);
    }
}
