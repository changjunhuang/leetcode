package array;

import java.util.ArrayList;
import java.util.List;

public class 找区间 {
    public static void main(String[] args) {
        List<List<Object>> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        System.out.println(list2.size());
        for (Object obj : list2){
            System.out.println(obj +"boj");
        }
    }

    private static void find() {
        int[][] array = new int[8][100];

        int left = 0;
        int minRight = 99;

        //  列
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            //  行
            for (int j = 0; j < array[0].length; j++) {
                int before = array[j][i];
                int after = array[j][i + 1];
                if(before!=after){
                    minRight = i;
                    flag = true;
                    break;
                }
            }
        }
    }
}
