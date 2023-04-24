package interview.anyway;

import java.util.Stack;

/**
 * @author huangchangjun
 * @date
 */
public class Test4 {
    public static void main(String[] args) {
        String str = "}{{}}{{{";
        System.out.println(countRev(str));

        String str2 = "{{}{{{}{{}}{{";
        System.out.println(countRev(str2));

        String str3 = "{{}{}{}}{{";
        System.out.println(countRev(str3));
    }


    //  S = "}{{}}{{{"   to     "{{{}}{}}"      }{{{
    //  S = "{{}{{{}{{}}{{"     to  "{{{{{{"
    public static int countRev(String str) {
        if (str == null || "".equals(str)) {
            return -1;
        }

        Stack<Character> stack = new Stack<>();
        //  入栈，符合的括号不入栈，只有异常的才add
        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(str.charAt(i));
                continue;
            }
            if (str.charAt(i) == '}') {
                if (stack.peek() == '{') {
                    //  匹配，出栈
                    stack.pop();
                    continue;
                }
            }
            stack.add(str.charAt(i));
        }

        //  "}{{{"
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        //  反转字符串
        String newStr = stringBuilder.reverse().toString();

        //  奇数字符串，不可能成功
        if (newStr.length() % 2 == 1) {
            return -1;
        }

        int result = 0;
        int left = 0;
        int righth = newStr.length() - 1;

        while (left < righth) {
            if (newStr.charAt(left) == '}') {
                result++;
                left++;
            }
            if (newStr.charAt(righth) == '{') {
                result++;
                righth--;
            }
        }
        return result;
    }
}
