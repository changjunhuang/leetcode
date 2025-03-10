package str.mid;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @author huangchangjun
 * @date 2025-03-09
 */
public class 找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        String str = "cbaebabacd";
        String target = "abc";
        List<Integer> anagrams = findAnagrams(str, target);
        System.out.println(anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        // 滑窗
        int[] sCount = new int[26];
        // 固定窗口
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        // 将第一个窗口和固定窗口比较，后续直接移动窗口位置
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        // 窗口每次右移一个单位，
        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            // 如果移动后的滑窗等于固定窗口，那么以为者是字母异位词
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}