package str;

import java.util.ArrayList;
import java.util.List;

/**
 * 20. 有效的括号
 */
public class 有效的括号 {
    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        List<Character> strList = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                strList.add(s.charAt(i));
            }

            //  ()的情况
            if (s.charAt(i) == ')') {
                if(strList.size() == 0){
                    return false;
                }
                if (strList.get(strList.size() - 1) != s.charAt(i) - 1) {
                    return false;
                }
                strList.remove(strList.size() - 1);
                continue;
            }

            // [] {} 的情况
            if (s.charAt(i) == '}' || s.charAt(i) == ']') {
                if(strList.size() == 0){
                    return false;
                }
                if (strList.get(strList.size() - 1) != s.charAt(i) - 2) {
                    return false;
                }
                strList.remove(strList.size() - 1);
                continue;
            }
        }

        if (strList.size() != 0) {
            return false;
        }
        return true;
    }
}
