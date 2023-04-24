package interview.anyway;

/**
 * @author huangchangjun
 * @date
 */
public class Test2 {

    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(array, 0, array.length - 1);

        for (int p = 0; p < array.length; p++) {
            System.out.println(array[p]);
        }
    }

    //  归并
    public static void mergeSort(int[] array, int l, int r) {
        int mid = (l + r) / 2;
        if (l < r) {
            mergeSort(array, l, mid);
            mergeSort(array, mid + 1, r);
            merge(array, l, mid, r);
        }
    }

    public static void merge(int[] array, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int k = 0;
        while (i <= m && j <= r) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= m) {
            temp[k++] = array[i++];
        }
        while (j <= r) {
            temp[k++] = array[j++];
        }

        for (int n = 0; n < temp.length; n++) {
            array[n + l] = temp[n];
        }
    }
}
