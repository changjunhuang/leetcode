package str;

public class 增减字符串匹配 {
    /**
     * 每次都是选最大或者最小的数进行操作，故所操作的数都是连续的
     *
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I') {
                ans[i] = lo++;
            } else {
                ans[i] = hi--;
            }
        }

        ans[N] = lo;
        return ans;
    }
}
