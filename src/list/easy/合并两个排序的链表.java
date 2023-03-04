package list.easy;

import pub.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 */
public class 合并两个排序的链表 {
    public ListNode mergeTwoLists(ListNode nodeA, ListNode nodeB) {
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val < nodeB.val) {
                temp.next = nodeA;
                nodeA = nodeA.next;
            } else {
                temp.next = nodeB;
                nodeB = nodeB.next;
            }
            temp = temp.next;
        }

        if (nodeA == null) {
            temp.next = nodeB;
        }
        if (nodeB == null) {
            temp.next = nodeA;
        }

        return pre.next;
    }
}
