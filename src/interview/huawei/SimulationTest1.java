package interview.huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huangchangjun
 * @date
 */
public class SimulationTest1 {

    public static void main(String[] args) {
        List<String> query = new ArrayList<>();
        query.add("nesw");
        query.add("woood");

        List<String> ask = new ArrayList<>();
        ask.add("new");
        ask.add("wod");

        System.out.println(riddle(query, ask));
    }

    /**
     * @param query 谜面
     * @param ask   谜底
     * @return
     */
    public static List<String> riddle(List<String> query, List<String> ask) {
        if (query.isEmpty() || ask.isEmpty()) {
            return new ArrayList<>();
        }

        //  为每个谜面设置hashset 列表,作为去重
        List<Set<Character>> querySetList = new ArrayList<>();
        for (String str : query) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }
            querySetList.add(set);
        }

        //  为每个谜底设置hashset 列表,作为去重
        List<Set<Character>> askSetList = new ArrayList<>();
        for (String str : ask) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }
            askSetList.add(set);
        }

        //  答案结果集
        List<String> result = new ArrayList<>();
        //  为每个谜面寻找答案
        //  遍历每一个谜面
        for (int k = 0; k < querySetList.size(); k++) {
            Set<Character> querySet = querySetList.get(k);
            for (int i = 0; i < askSetList.size(); i++) {
                Set set = askSetList.get(i);
                if (querySet.size() == set.size() && set.containsAll(querySet)) {
                    result.add(query.get(k));
                }
            }
        }

        return result;
    }
}
