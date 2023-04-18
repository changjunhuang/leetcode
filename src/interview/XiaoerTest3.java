package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchangjun
 * @date
 */
public class XiaoerTest3 {

    public static void main(String[] args) {
        getList(15);
    }

    public static void getList(int key) {
        if (key == 0) {
            return;
        }

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 1; i < key; i++) {
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < key; j++) {
                sum = sum + j;
                if (sum == key) {
                    lists.add(list);
                } else if (sum > key) {
                    break;
                }
                list.add(j);
            }
        }
        System.out.println(lists.toString());
    }
}
