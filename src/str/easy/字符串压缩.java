package str.easy;


/**
 * 面试题 01.06. 字符串压缩
 */
public class 字符串压缩 {
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaa"));
    }

    public static String compressString(String S) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < S.length(); ) {
            int num = 0;
            for (int k = i; k < S.length(); k++) {
                if (S.charAt(i) == S.charAt(k)) {
                    num++;
                } else {
                    break;
                }
            }
            stringBuilder.append(S.charAt(i));
            stringBuilder.append(num);
            i = i + num;
        }

        if (S.length() <= stringBuilder.length()) {
            return S;
        }

        return stringBuilder.toString();
    }
}
