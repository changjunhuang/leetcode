package arraylist.mid;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author huangchangjun
 * @date 2025-03-27
 */
public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        return quick_sort(nums, 0, nums.length - 1, k);
    }

    int quick_sort(int[] data, int left, int right, int k) {
        int i = left;
        int j = left;
        //旋转点
        int pivot = data[right];

        if (left < right) {

            // 从大到小对数组进行快排
            for (; j < right; j++) {
                if (data[j] > pivot) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    i++;
                }
            }

            data[j] = data[i];
            data[i] = pivot;

            // pivot 此时位于索引 i 处，i - left + 1 表示 pivot 是第几大的数
            int which_max = i - left + 1;
            // pivot 正好是第 k 大的数
            if (which_max == k) {
                return pivot;
            }

            // 第 k 大的数在 pivot 右边，问题转化为找右边数组第 (k - which_max) 大的元素
            // 比如 pivot 是第四大的数，要找第五大的数，则继续找右边数组第一大的数即可
            else if (which_max < k) {
                return quick_sort(data, i + 1, right, k - which_max);
            }

            // 第 k 大的数在 pivot 左边，问题转化为找左边数组第 k 大的元素
            // 比如 pivot 是第三大的数，要找第二大的数，则继续找左边数组第二大的数即可
            else {
                return quick_sort(data, left, i - 1, k);
            }
        } else {                //这里就是 left == right
            return pivot;
        }
    }

    public static int getMiddle(int[] array, int left, int right) {
        int key = array[left];

        while (left < right) {
            while (left < right && array[right] >= key)
                right--;
            array[left] = array[right];
            while (left < right && array[left] <= key)
                left++;
            array[right] = array[left];
        }

        array[left] = key;
        return left;

    }
}
