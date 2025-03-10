package arraylist.mid;

import java.util.*;

/**
 * 15. 三数之和
 * 三数之和等于0
 *
 * @author huangchangjun
 * @date 2025-03-08
 */
public class 三数之和 {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println(threeSum(arr));
    }

    // 大量数据情况下，leetcode判题超时，时间复杂度O(n^2)，较高
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Set<String> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int tempkey = nums[i];
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    int temp = -(nums[j] + tempkey);
                    if (map.containsKey(temp) && j != map.get(temp) && i != map.get(temp)) {
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(temp);
                        tempList.sort(Comparator.naturalOrder());
                        if (!tempList.isEmpty() && !set.contains(tempList.toString())) {
                            set.add(tempList.toString());
                            // 这里需要重新new一个对象，否则会出现引用问题，下边的clear会导致result中的数据被清空
                            result.add(new ArrayList<>(tempList));
                        }
                        tempList.clear();
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
