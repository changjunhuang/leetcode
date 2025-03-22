package arraylist.mid;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author huangchangjun
 * @date 2025-03-22
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(searchRange(arr, 8));
    }

    // todo 不是很理解
    public static int[] searchRange(int[] nums, int target) {
        // 左边起始点，左闭右开
        int leftIdx = binarySearch(nums, target, true);
        // 右边终止点
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}