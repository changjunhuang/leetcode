package interview.huawei;

import java.util.Scanner;

/**
 * @author huangchangjun
 * @date
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] strings = str.split(",");

        int key = scanner.nextInt();
        System.out.println(getMaxSum(strings, key));
    }

    //2,10,-3,-8,40,5
    //4
    public static int getMaxSum(String[] strings, int key) {
        if (key <= 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < strings.length - key + 1; i++) {
            int current = 0;
            for (int j = 0; j <= key - 1; j++) {
                current = current + Integer.parseInt(strings[i + j]);
            }
            result = Math.max(result, current);
        }

        return result;
    }
}
