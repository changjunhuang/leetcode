package interview;

import java.util.*;

/**
 * @author huangchangjun
 * @date
 */
public class Main2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);

        System.out.println(topKFrequent(list, 2));

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        System.out.println(topKFrequent(list, 1));
    }


    //给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    //示例 1:
    //1-3 2-2 , list = 1 2
    //输入: nums = [1,1,1,2,2,3], k = 2
    //输出: [1,2]
    //示例 2:
    //
    //输入: nums = [1], k = 1
    //输出: [1]
    public static List<Integer> topKFrequent(List<Integer> list, int key) {
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int tempKey = list.get(i);
            if (map.containsKey(list.get(i))) {
                map.put(tempKey, map.get(tempKey) + 1);
            } else {
                map.put(tempKey, 1);
            }
        }
        for (int i : map.keySet()) {
            int val = map.get(i);
            if (resultList.size() < key) {
                resultList.add(i);
            } else {
                if (val > map.get(resultList.get(0))) {
                    resultList.set(0, i);
                }
            }
            Collections.sort(resultList);
        }
        return resultList;
    }
}
