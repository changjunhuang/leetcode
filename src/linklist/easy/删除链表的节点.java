package linklist.easy;

import pub.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 */
public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode node = preHead;

        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
                continue;
            }
            node = node.next;
        }
        return preHead.next;
    }
}
