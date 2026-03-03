
/**
 * @author huangchangjun
 * @date
 */
public class Test {
    public static void main(String[] args) {
        int[] array = {20, 90, 50, 70, 80, 30, 40, 20, 30, 10};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int index = dfs(array, left, right);
            quickSort(array, left, index - 1);
            quickSort(array, index + 1, right);
        }
    }

    private static int dfs(int[] array, int left, int right) {
        int key = array[left];
        while (left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] < key) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = key;
        return left;
    }

}