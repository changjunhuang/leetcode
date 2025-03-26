package arraylist.mid;

/**
 * 287. 寻找重复数
 *
 * @author huangchangjun
 * @date 2025-03-24
 */
public class 寻找重复数 {

    // 类似环形链表的解法
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        // 每次往前走的距离不固定，走的距离为当前数组的值
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 第一个循环走完，找到第一个节点
        // 第二个循环，每次走一步，相遇之后，就是第二个节点
        int pre1 = 0;
        int pre2 = slow;
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
