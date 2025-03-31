package stack_queue.mid;

import java.util.Stack;

/**
 * 394. 字符串解码
 *
 * @author huangchangjun
 * @date 2025-03-31
 */
public class 字符串解码 {
    public static void main(String[] args) {
        String str = "3[a]2[bc]";
        System.out.println(decodeString(str));
    }

    public static String decodeString(String s) {
        Stack<Character> first = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder stringBuilder = new StringBuilder();
                while (first.peek() != '[') {
                    Character pop = first.pop();
                    stringBuilder.append(pop);
                }
                first.pop();
                stringBuilder.reverse();
                StringBuilder timesNum = new StringBuilder();
                while (!first.isEmpty() && Character.isDigit(first.peek())) {
                    timesNum.append(first.pop());
                }
                timesNum.reverse();
                int num = Integer.parseInt(timesNum.toString());
                for (int j = 0; j < num; j++) {
                    for (int z = 0; z < stringBuilder.length(); z++) {
                        first.push(stringBuilder.charAt(z));
                    }
                }
            } else {
                first.push(s.charAt(i));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : first) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }
}
