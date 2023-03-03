package list.easy;

import pub.ListNode;

public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode before = head.next;
        ListNode after = head;
        while (before != after) {
            if (before == null || before.next == null) {
                return false;
            }
            before = before.next.next;
            after = after.next;
        }
        return true;
    }
}
