package arraylist.hard;

/**
 * 42. 接雨水
 *
 * @author huangchangjun
 * @date 2025-03-08
 */
public class 接雨水 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap2(height));
    }

    public static int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }
        int max = -1, maxIndex = 0;
        int i = 0;
        //找最大的元素 所在的 元素索引
        for (; i < n; ++i) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        //分别从数组 left 和 right 开始向最高点遍历，求面积
        int area = 0;
        //记录遍历过去数组的每次最大值
        int hight = height[0];

        for (i = 0; i < maxIndex; ++i) {
            // 如果当前元素比root小，说明可以接雨水
            if (hight < height[i]) {
                hight = height[i];
            } else {
                area = area + (hight - height[i]);
            }
        }
        for (i = n - 1, hight = height[n - 1]; i > maxIndex; --i) {
            if (hight < height[i]) {
                hight = height[i];
            } else {
                area = area + (hight - height[i]);
            }
        }
        return area;
    }


    public static int trap2(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }

        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int area = 0;

        while (left < right) {
            // 左右指针最终都会遍历到最大值，所以不用担心最大值被跳过
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    area += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    area += rightMax - height[right];
                }
                right--;
            }
        }
        return area;
    }
}
