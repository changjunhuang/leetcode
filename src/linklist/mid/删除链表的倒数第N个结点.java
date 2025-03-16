package linklist.mid;

import pub.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class 删除链表的倒数第N个结点 {
    //  快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode pre = temp;
        ListNode after = temp;

        //  快指针先走n步
        for (int i = 0; i < n; i++) {
            pre = pre.next;
            if (pre == null) {
                return head;
            }
        }

        //  快慢指针同时往前走，当快指针走到最后一个节点时，慢指针的下一个节点就是要删除的节点
        while (pre.next != null) {
            pre = pre.next;
            after = after.next;
        }
        after.next = after.next.next;

        return temp.next;
    }
}
