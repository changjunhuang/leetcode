package arraylist.mid;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * @author huangchangjun
 * @date 2025-03-22
 */
public class 寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        // 定义双指针
        // 找中间的index
        // 如果找到对比左右指针，如果比左指针小，则中间点位于右侧数组中，right=mid
        // 如果中间点比左大，比右小，意味着中间点位于左侧数组中，这时候left = mid + 1
        // 当左右指针碰撞，返回数组中left位置数字即可
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 在右侧数组
            if (nums[mid] < nums[right]) {
                // 不能是mid - 1，有可能会错过当前数字
                right = mid;
            } else {
                // 左侧数组
                left = mid + 1;
            }
        }
        return nums[left];
    }
}