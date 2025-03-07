package array.mid;

import java.util.*;

/**
 * 128. 最长连续序列
 *
 * @author huangchangjun
 * @date 2025-03-08
 */
public class 最长连续序列 {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int maxLength = 0;
    public static int tempLength = 0;

    //  递归实现
    public static int longestConsecutive(int[] nums) {
        maxLength = 0;
        tempLength = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        List<Integer> list = new ArrayList<>(numSet);

        for (int num : list) {
            tempLength = 0;
            dfs(num, numSet);
            maxLength = Math.max(maxLength, tempLength);
        }
        return maxLength;
    }

    public static void dfs(int num, Set<Integer> numSet) {
        if (!numSet.contains(num)) {
            return;
        }
        tempLength++;
        numSet.remove(num);
        dfs(num + 1, numSet);
        dfs(num - 1, numSet);
    }

    //hashset的实现,每次删除set中的值可以减少 重复计算
    public int longestConsecutive2(int[] nums) {
        int res = 0;
        Set<Integer> s = new HashSet<>();
        //将数组的数存进set ,无序唯一
        for (int num : nums) {
            s.add(num);
        }
        //遍历数组，如果set 中能成功删除  设置pre 和 next 的值
        for (int num : nums) {
            //set中有在这个值 ，移除后返回true
            if (s.remove(num)) {
                int pre = num - 1, next = num + 1;
                //如果前一个的值能删除成功，pre--继续删除
                while (s.remove(pre)) {
                    pre--;
                }
                //如果后一个的值能删除成功，next++继续删除
                while (s.remove(next)) {
                    next++;
                }
                res = Math.max(res, next - pre - 1);
            }
        }
        return res;
    }

    //hashmap的实现
    public int longestConsecutive3(int[] nums) {
        int res = 0;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (m.containsKey(num))
                continue;
            int left = m.containsKey(num - 1) ? m.get(num - 1) : 0;
            int right = m.containsKey(num + 1) ? m.get(num + 1) : 0;
            int sum = left + right + 1;

            m.put(num, sum);
            res = Math.max(res, sum);
            m.put(num - left, sum);
            m.put(num + right, sum);
        }
        return res;
    }
}
