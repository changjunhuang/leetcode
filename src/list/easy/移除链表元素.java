package list.easy;

import pub.ListNode;

public class 移除链表元素 {

    public static void main(String[] args) {
        ListNode node = new ListNode(7);
        node.next = new ListNode(7);
        node.next.next = new ListNode(7);
        node.next.next.next = new ListNode(7);

        ListNode result = removeElements(node, 7);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode right = newHead;

        while (right.next != null) {
            if (right.next.val == val) {
                right.next = right.next.next;
            } else {
                right = right.next;
            }
        }
        return newHead.next;
    }
}
