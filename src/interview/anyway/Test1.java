package interview.anyway;

/**
 * @author huangchangjun
 * @date
 */
public class Test1 {

    public static void main(String[] args) {
        String str1 = "ABCDGH";
        String str2 = "ACDGHR";
        System.out.println(longestCommonSubstr(str1, str2, str1.length(), str2.length()));
    }

    //  Input:S1 = "ABCDGH", S2 = "ACDGHR", n = 6, m = 6  ; return 4
    public static int longestCommonSubstr(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        int result = 0;
        String maxLength = n >= m ? str1 : str2;
        String minLength = n < m ? str1 : str2;

        for (int i = 0; i < maxLength.length(); i++) {
            int temp = 0;
            int i_temp = i;
            for (int j = 0; j < minLength.length(); j++) {
                if (i_temp <= maxLength.length() - 1 && maxLength.charAt(i_temp) == minLength.charAt(j)) {
                    temp++;
                    i_temp++;
                } else {
                    temp = 0;
                }
            }
            result = Math.max(result, temp);
        }
        return result;
    }
}
