package arraylist.hard;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * @author huangchangjun
 * @date 2025-03-21
 */
public class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        // 数组长度为偶数
        boolean isEven = length % 2 == 0;
        int[] tempArray = new int[length / 2 + 1];
        int firstIndex = 0;
        int secondIndex = 0;
        int tempIndex = 0;

        while (tempIndex < tempArray.length) {
            if (firstIndex < nums1.length && secondIndex < nums2.length) {
                if (nums1[firstIndex] <= nums2[secondIndex]) {
                    tempArray[tempIndex++] = nums1[firstIndex++];
                } else {
                    tempArray[tempIndex++] = nums2[secondIndex++];
                }
            } else if (firstIndex >= nums1.length - 1 && secondIndex < nums2.length) {
                tempArray[tempIndex++] = nums2[secondIndex++];
            } else if (firstIndex < nums1.length) {
                tempArray[tempIndex++] = nums1[firstIndex++];
            }
        }
        return isEven ? (tempArray[tempArray.length - 1] + tempArray[tempArray.length - 2]) / 2.0 : tempArray[tempArray.length - 1];
    }
}
