package arraylist.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 239. 滑动窗口最大值
 *
 * @author huangchangjun
 * @date 2026-01-09
 */
public class 滑动窗口最大值 {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = 滑动窗口最大值.maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 移除队头不在窗口内的下标
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // 保持队列递减，移除比当前元素小的下标
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 记录窗口最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    // 这个方法大部分测试用例能通过，少量场景会失败。但实现简单
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= nums.length - k; i++) {
            int currentMax = -1;
            for (int j = i; j < i + k; j++) {
                currentMax = Math.max(currentMax, nums[j]);
            }
            result.add(currentMax);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
