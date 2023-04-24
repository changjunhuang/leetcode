package interview.anyway;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huangchangjun
 * @date
 */
public class Test3 {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 3, 6};
        System.out.println(find3Numbers(array, 9));

        int[] array2 = {1, 4, 45, 6, 10, 8};
        System.out.println(find3Numbers(array2, 15));
    }


    //  arr[] = [1 2 4 3 6]
    public static boolean find3Numbers(int[] array, int key) {
        if (array == null) {
            return false;
        }

        //  将数组元素放入set中去重
        Set<Integer> set = new HashSet<>();
        for (int m = 0; m < array.length; m++) {
            set.add(array[m]);
        }

        //  通过set集合判断，是否存在三数之和等于key
        for (int i = 0; i < array.length; i++) {
            int tempKey = key - array[i];
            for (int j = 0; j < array.length; j++) {
                if (array[j] != array[i]) {
                    int temp = tempKey - array[j];
                    if (set.contains(temp)) {
                        System.out.println("result is : " + array[i] + "," + array[j] + "," + temp);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
