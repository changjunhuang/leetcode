package list.easy;

import pub.ListNode;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 */
public class 返回倒数第k个节点 {

    static int result;

    public static int kthToLast(ListNode head, int k) {
        getResult(head, k);
        return result;
    }

    public static int getResult(ListNode head, int k) {
        if (head.next == null) {
            if (k == 1) {
                result = head.val;
            }
            return 1;
        }
        int num = getResult(head.next, k);
        num = num + 1;
        if (num == k) {
            result = head.val;
        }
        return num;
    }
}
