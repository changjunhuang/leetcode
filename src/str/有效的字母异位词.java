package str;

import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) throws Exception {
        if (s.length() != t.length()) {
            return false;
        }
        try {
            HashMap<Character, Integer> map = new HashMap<>();
            for (Character ch : s.toCharArray()) {
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    int i = map.get(ch);
                    map.put(ch, i + 1);
                }
            }

            for (Character ch : t.toCharArray()) {
                if (map.get(ch) != null) {
                    int j = map.get(ch) - 1;
                    if(j == 0){
                        map.remove(ch);
                    }else{
                        map.put(ch, j);
                    }
                } else {
                    return false;
                }
            }
        }catch (Exception e){
        }
        return true;
    }
}
