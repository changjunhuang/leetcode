package str.mid;

import java.util.Stack;

/**
 * 1190. 反转每对括号间的子串
 *
 * @author huangchangjun
 * @date 2023/5/24
 */
public class 反转每对括号间的子串 {

    public static void main(String[] args) {
        String str = "(u(love)i)";

        System.out.println(reverseParentheses(str));
    }


    //  "(u(love)i)"
    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                //  弹出 (
                stack.pop();
                //  重新塞入栈中
                reverseStr(sb, stack);
            } else {
                //  stack.add 和stack.push 作用相同
                stack.add(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void reverseStr(StringBuilder stringBuilder, Stack<Character> stack) {
        for (int i = 0; i < stringBuilder.length(); i++) {
            stack.add(stringBuilder.charAt(i));
        }
    }
}
