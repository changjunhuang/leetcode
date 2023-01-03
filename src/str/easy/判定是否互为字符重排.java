package str.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.02. 判定是否互为字符重排
 */
public class 判定是否互为字符重排 {

    //  可以把hashMap优化成长度为26的字符数组,使用ascll码进行哈希映射s
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }
        }

        for (int j = 0; j < s2.length(); j++) {
            if (map.containsKey(s2.charAt(j))) {
                if (map.get(s2.charAt(j)) == 1) {
                    map.remove(s2.charAt(j));
                } else {
                    map.put(s2.charAt(j), map.get(s2.charAt(j)) - 1);
                }
            } else {
                return false;
            }
        }

        if (map.size() == 0) {
            return true;
        }
        return false;
    }
}
