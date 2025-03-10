package linklist.easy;

import pub.ListNode;

/**
 * 876. 链表的中间结点
 */
public class 链表的中间结点 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        System.out.println(middleNode(listNode1).val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        // 快指针走两步，慢指针走一步，快指针走到头，慢指针走到中间，如果是偶数个节点，慢指针走到中间两个节点的后一个
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
