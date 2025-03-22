package arraylist.easy;

/**
 * 35. 搜索插入位置
 *
 * @author huangchangjun
 * @date 2025-03-21
 */
public class 搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
