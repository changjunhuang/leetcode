package interview.kuaikan;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author huangchangjun
 * @date
 */
public class KuaiKanFace1 {
    public static void main(String[] args) {
        int[][] arrays = {{1, 3}, {2, 2}, {3, 1}};
        int result = getMaxSize(arrays, 4);
        System.out.println(result);
    }


    public static int getMaxSize(int[][] array, int truckSize) {
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int maxSize = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            int num = array[i][0];
            for (int j = num; truckSize != 0 && j > 0; j--) {
                truckSize = truckSize - 1;
                maxSize = maxSize + array[i][1];
            }
        }
        return maxSize;
    }
}
