package list;

import pub.ListNode;

public class 奇偶链表 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode3.next = null;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode node = oddEvenList(listNode1);
        while (node.next != null) {
            System.out.println(node.val);
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
