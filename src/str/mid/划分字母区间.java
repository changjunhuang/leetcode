package str.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 *
 * @author huangchangjun
 * @date 2025-06-25
 */
public class 划分字母区间 {
    public static List<Integer> partitionLabels(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            // 每个字母最后出现的下标
            last[s[i] - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            // 更新当前区间右端点的最大值
            end = Math.max(end, last[s[i] - 'a']);
            // 当前区间合并完毕
            if (end == i) {
                // 区间长度加入答案
                ans.add(end - start + 1);
                // 下一个区间的左端点
                start = i + 1;
            }
        }
        return ans;
    }
}
