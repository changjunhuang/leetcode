package sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author huangchangjun
 * @date 2024/02/27
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {20, 90, 50, 70, 80, 30, 40, 20, 30, 10};
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            // 确定唯一排序值的位置
            int index = partition(array, left, right);
            // 左侧子数组
            quickSort(array, left, index - 1);
            // 右侧子数组
            quickSort(array, index + 1, right);
        }
    }


    /**
     * 用第一个元素将待排序序列划分分为左右两个部分，一趟排序必定确定一个值的位置
     */
    private static int partition(int[] array, int left, int right) {
        // 把第一个元素当作枢轴
        int key = array[left];

        // 用left、right搜索枢轴的最终位置，
        // 当left 与 right 相碰的时候和或者 left 溢出 right 的时候结束
        while (left < right) {
            // 比枢轴小的元素移动到左端
            while (left < right && array[right] >= key) {
                right--;
            }
            // 出现右侧数据大于key时，与左侧指针进行交换
            array[left] = array[right];

            // 比枢轴大的元素移动到右端
            while (left < right && array[left] <= key) {
                left++;
            }
            array[right] = array[left];
        }
        // while循环停止时，此时left和right指针一致，array[left] 等于 array[right]，所指元素为重复元素
        array[left] = key;
        return left;
    }
}
