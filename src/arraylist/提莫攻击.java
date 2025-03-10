package arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * 495. 提莫攻击
 */
public class 提莫攻击 {
    public static void main(String[] args) {
        int[] array = new int[2];
        array[0] = 1;
        array[1] = 4;

        System.out.println(findPoisonedDuration(array, 2));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0 || duration == 0) {
            return 0;
        }

        //  左右指针
        int left = 1;
        int right = 1;

        List<Integer> timeList = new ArrayList();

        for (int i = 0; i < timeSeries.length; i++) {
            if (i == 0) {
                right = left + duration - 1;
                continue;
            }
            if (timeSeries[i] > right) {
                timeList.add(right - left + 1);
                left = timeSeries[i];
                right = left + duration - 1;
                continue;
            }
            if (timeSeries[i] <= right) {
                right = timeSeries[i] + duration - 1;
            }
        }
        //  最后一次中毒后记录中毒时间
        timeList.add(right - left + 1);

        int result = 0;
        for (int i = 0; i < timeList.size(); i++) {
            result += timeList.get(i);
        }

        return result;
    }
}
