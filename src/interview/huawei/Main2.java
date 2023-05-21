package interview.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author huangchangjun
 * @date
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int arrayNum = scanner.nextInt();
        List<List<String>> arrays = new ArrayList<>();


        for (int i = 0; i < arrayNum; i++) {
            String[] array = scanner.next().split(",");
            arrays.add(Arrays.asList(array));
        }

        List<Integer> result = mergeArrays(arrays, len);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(",");
            }
        }
    }


    //4
    //3
    //1,2,3,4,5,6
    //1,2,3
    //1,2,3,4
    public static List<Integer> mergeArrays(List<List<String>> arrays, int len) {
        if (arrays.size() == 0 || len == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();

        //  统计所有元素的长度
        int sum = 0;
        for (int i = 0; i < arrays.size(); i++) {
            sum = sum + arrays.get(i).size();
        }

        //  以所有元素为条件的一个大循环
        int outIndex = 0;
        int innerIndex = 0;
        while (true) {
            //  计算一维数组索引
            outIndex = outIndex % arrays.size();

            if (innerIndex + len < arrays.get(outIndex).size()) {
                for (int j = innerIndex; j < innerIndex + len; j++) {
                    list.add(Integer.parseInt(arrays.get(outIndex).get(j)));
                }
                sum = sum - len;
            } else if (innerIndex < arrays.get(outIndex).size() && innerIndex + len >= arrays.get(outIndex).size()) {
                for (int j = innerIndex; j < arrays.get(outIndex).size(); j++) {
                    list.add(Integer.parseInt(arrays.get(outIndex).get(j)));
                }
                sum = sum - (arrays.get(outIndex).size() - innerIndex);
            }

            outIndex++;
            if (outIndex % arrays.size() == 0) {
                innerIndex = innerIndex + len;
            }

            if (sum <= 0) {
                break;
            }
        }
        return list;
    }
}
