package stack_queue_heap.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 *
 * @author huangchangjun
 * @date 2025-04-01
 */
public class 柱状图中最大的矩形 {

    public static void main(String[] args) {
        柱状图中最大的矩形 solution = new 柱状图中最大的矩形();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = solution.largestRectangleArea(heights);
        // 输出: 最大矩形面积: 10
        System.out.println("最大矩形面积: " + result); 
    }

    // heights = [2,1,5,6,2,3]
    public int largestRectangleArea(int[] heights) {
        // 如果没有柱子，返回0
        int n = heights.length;
        // 如果没有柱子，默认左边界为-1
        int[] left = new int[n];
        // 如果没有柱子，默认右边界为n
        int[] right = new int[n];
        Arrays.fill(right, n);

        // 使用单调栈来计算每个柱子的左边界和右边界
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
