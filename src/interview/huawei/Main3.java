package interview.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author huangchangjun
 * @date
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //  数组的数量
            int n = scanner.nextInt();
            //  目标key
            int m = scanner.nextInt();

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int number = scanner.nextInt();
                list.add(number);
            }
            System.out.println(judge(list, m));
        }
    }


    //6 7
    //2 12 6 3 5 5

    //10 11
    //1 1 1 1 1 1 1 1 1 1
    public static int judge(List<Integer> list, int key) {
        if (list.isEmpty() || key == 0) {
            return 0;
        }

        //  遍历各种情况
        for (int i = 1; i <= list.size(); i++) {
            //  每种情况下数组的遍历
            for (int j = 0; j < list.size(); ) {
                int currentSum = 0;
                //  遍历每个步长
                if (j + i <= list.size()) {
                    for (int k = j; k < j + i; k++) {
                        currentSum = currentSum + list.get(k);
                    }
                } else {
                    j = j + i;
                    continue;
                }

                if (currentSum % key == 0) {
                    return 1;
                }
                j = j + i;
            }
        }
        return 0;
    }
}
