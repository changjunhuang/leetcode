package arraylist.mid;

/**
 * 11. 盛最多水的容器
 *
 * @author huangchangjun
 * @date 2025-03-08
 */
public class 盛最多水的容器 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int len = right - left;
            int higth = Math.min(height[left], height[right]);
            int max = len * higth;
            maxArea = Math.max(max, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
