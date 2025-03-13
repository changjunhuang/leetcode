package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * @author huangchangjun
 * @date 2025-03-10
 */
public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows <= 0) {
            return list;
        }

        if (numRows <= 2) {
            for (int i = 1; i <= numRows; i++) {
                List<Integer> li = new ArrayList<>();
                for (int j = i; j > 0; j--) {
                    li.add(1);
                }
                list.add(li);
            }
            return list;
        }

        for (int i = 1; i <= 2; i++) {
            List<Integer> li = new ArrayList<>();
            for (int j = i; j > 0; j--) {
                li.add(1);
            }
            list.add(li);
        }

        // 从第三行开始
        for (int i = 3; i <= numRows; i++) {
            List<Integer> li = new ArrayList<>();
            li.add(1);
            // 从第三行开始，每一行的元素等于上一行的right + right-1
            for (int j = i - 2; j > 0; j--) {
                int temp = list.get(i - 2).get(j) + list.get(i - 2).get(j - 1);
                li.add(temp);
            }
            li.add(1);
            list.add(li);
        }

        return list;
    }
}
