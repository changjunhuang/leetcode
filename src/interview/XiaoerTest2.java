package interview;

import java.util.Stack;

/**
 * @author huangchangjun
 * @date
 */
public class XiaoerTest2 {

    public static void main(String[] args) {
        String str = "()(())";

        System.out.println(getStrLength2(str));

    }

    public static int getStrLength2(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            if (str.charAt(i) == ')') {
                //  出栈 (
                stack.pop();
            }
            result++;
        }
        return result;
    }
}
