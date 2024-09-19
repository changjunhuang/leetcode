package interview;

import java.util.Arrays;

public class WenwenCoding {


    public static void main(String[] args) {
        int key = 1;
        int[] array = {81, 21, 31, 61, 11, 1, 71, 41, 51};
        Arrays.sort(array);
        int result = getIndexKey(array, 0, array.length - 1, key);

        System.out.println(Arrays.toString(array));
        System.out.println(result);
    }

    public static int getIndexKey(int[] array, int left, int right, int key) {
        if (array == null || array.length == 0 || left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (key == array[mid]) {
            return mid;
        }

        int leftTemp = getIndexKey(array, left, mid - 1, key);
        int rightTemp = getIndexKey(array, mid + 1, right, key);
        return leftTemp > -1 ? leftTemp : rightTemp;
    }

}
