package str;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 */
public class 字符串的排列 {
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap();
        Map<Character, Integer> s2map = new HashMap();
        setMap(s1Map, s1, 0, s1.length());

        int left = 0;
        int right = s1.length() - 1;

        while (right < s2.length()) {
            setMap(s2map, s2, left, right + 1);
            int currentNum = 0;
            for (int i = left; i <= right; i++) {
                if ((s1Map.containsKey(s2.charAt(i)) &&
                        s2map.get(s2.charAt(i)).equals(s1Map.get(s2.charAt(i))))) {
                    //  加一个currentNum，用于判断是否遍历s2中的字串完成
                    currentNum++;
                    if (currentNum == right - left + 1) {
                        return true;
                    }
                } else {
                    s2map.clear();
                    break;
                }
            }
            left++;
            right++;
        }
        return false;
    }

    public static void setMap(Map<Character, Integer> map, String str, int left, int right) {
        for (int i = left; i < right; i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
    }

}
