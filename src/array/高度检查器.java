package array;

/**
 * 1051. 高度检查器
 * 没理解 ，大概是用数组的索引位置来计总数
 */
public class 高度检查器 {
    public int heightChecker(int[] heights) {
        int[] same = new int[101];
        int[] before = new int[101];
        // 统计每种种类数字个数
        for (int i : heights) {
            same[i]++;
        }
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            before[i] = sum;
            sum = before[i] + same[i];
        }
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i >= before[heights[i]] + same[heights[i]] || i < before[heights[i]]) {
                count++;
            }
        }
        return count;
    }
}
