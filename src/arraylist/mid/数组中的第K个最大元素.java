package arraylist.mid;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author huangchangjun
 * @date 2025-03-27
 */
public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    int quickSort(int[] data, int left, int right, int k) {
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
            int whichMax = i - left + 1;
            // pivot 正好是第 k 大的数
            if (whichMax == k) {
                return pivot;
            }

            // 第 k 大的数在 pivot 右边，问题转化为找右边数组第 (k - which_max) 大的元素
            // 比如 pivot 是第四大的数，要找第五大的数，则继续找右边数组第一大的数即可
            else if (whichMax < k) {
                return quickSort(data, i + 1, right, k - whichMax);
            }

            // 第 k 大的数在 pivot 左边，问题转化为找左边数组第 k 大的元素
            // 比如 pivot 是第三大的数，要找第二大的数，则继续找左边数组第二大的数即可
            else {
                return quickSort(data, left, i - 1, k);
            }
        } else {                //这里就是 left == right
            return pivot;
        }
    }
}
