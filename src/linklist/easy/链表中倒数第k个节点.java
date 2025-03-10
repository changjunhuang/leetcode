package linklist.easy;

import pub.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class 链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            if (fast.next == null) {
                return head;
            }
            fast = fast.next;
        }

        ListNode after = head;
        while (fast.next != null) {
            fast = fast.next;
            after = after.next;
        }
        return after;
    }
}
