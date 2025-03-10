package linklist.easy;

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

    /**
     * O（n）
     *
     * @param head
     * @param k
     * @return
     */
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

    /**
     * 快慢指针法
     *
     * @param head
     * @param k
     * @return
     */
    public static int getResult2(ListNode head, int k) {
        if (head == null) {
            return -1;
        }

        ListNode pre = head;
        for (int i = 0; i < k; i++) {
            pre = pre.next;
        }
        while (pre != null) {
            pre = pre.next;
            head = head.next;
        }
        return head.val;
    }
}
