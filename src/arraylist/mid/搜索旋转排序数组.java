package arraylist.mid;

/**
 * 33. 搜索旋转排序数组
 *
 * @author huangchangjun
 * @date 2025-03-21
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        // 二分，左右两个指针
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                // 当Mid值小于 最右边的值时 ，右边元素递增，找到有序的一边
                // Mid < target <= right ，取右边
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    // 否则取左边
                    right = mid - 1;
                }
            } else {
                // mid大于最右边的数 ， 左边元素递增，找到有序的一边
                // left <= target <mid ,取左边
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    // 否则，取右边
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
