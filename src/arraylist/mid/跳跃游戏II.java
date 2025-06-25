package arraylist.mid;

/**
 * 45. 跳跃游戏 II
 *
 * @author huangchangjun
 * @date 2025-06-20
 */
public class 跳跃游戏II {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int result = jump(nums);
        System.out.println("Minimum jumps to reach the end: " + result);
    }

    // [2,3,1,1,4]
    // [2,3,0,1,4]
    // 从后往前找
    public static int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    // [2,3,1,1,4]
    // [2,3,0,1,4]
    public static int jump2(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
