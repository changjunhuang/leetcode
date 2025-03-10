package linklist.mid;

import pub.ListNode;

/**
 * 92. 反转链表 II
 * 代码不完善，部分案例无法通过
 */
public class 反转链表II {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseBetween(head, 2, 4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode preNext = head.next;

        //  定位左
        for (int i = 1; i < left - 1; i++) {
            pre = pre.next;
            preNext = preNext.next;
        }
        pre.next = null;

        //  定位右
        ListNode after = preNext;
        for (int j = 1; j < right - left + 1; j++) {
            after = after.next;
        }
        ListNode afterNext = after.next;
        after.next = null;

        //反转子链表
        ListNode midRight = reverseList(preNext);

        //拼接
        pre.next = midRight;
        while (midRight.next != null) {
            midRight = midRight.next;
        }
        midRight.next = afterNext;

        return head;
    }

    //  反转链表
    private static ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode temp = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return temp;
    }
}
