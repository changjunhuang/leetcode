package interview.huawei;

/**
 * @author huangchangjun
 * @date
 */
public class SimulationTest3 {

    public static void main(String[] args) {
        int[] array = {2, 5, 3, 6, 5, 6};

        int[] array2 = {2, 3, 4, 5, 6, 6, 5, 4, 3, 2};

        System.out.println(getCenterIndex(array2));
    }

    public static int getCenterIndex(int[] array) {
        if (array.length == 0) {
            return -1;
        }

        int leftTotal = 1;
        int rightTotal = 1;

        for (int index = 0; index < array.length; index++) {
            leftTotal = leftTotal * array[index];

            for (int j = index + 1; j < array.length; j++) {
                rightTotal = rightTotal * array[j];

                if (leftTotal == rightTotal) {
                    return array[index];
                }
                if (leftTotal < rightTotal) {
                    rightTotal = 1;
                    break;
                }
            }
        }
        return -1;
    }
}
