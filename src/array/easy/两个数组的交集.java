package array.easy;

import java.util.*;

/**
 * 349. 两个数组的交集
 */
public class 两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] max;
        int[] min;
        if (nums1.length > nums2.length) {
            max = nums1;
            min = nums2;
        } else {
            max = nums2;
            min = nums1;
        }

        for (int i = 0; i < min.length; i++) {
            if (!map.containsKey(min[i])) {
                map.put(min[i], 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < max.length; j++) {
            if (map.containsKey(max[j])) {
                list.add(max[j]);
                map.remove(max[j]);
            }
        }

        int[] array = new int[list.size()];
        for (int z = 0; z < array.length; z++) {
            array[z] = list.get(z);
        }
        return array;
    }
}
