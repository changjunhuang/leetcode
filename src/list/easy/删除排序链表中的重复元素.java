package list.easy;

import pub.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 *
 * @author huangchangjun
 * @date 2025-03-06
 */
public class 删除排序链表中的重复元素 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return preHead.next;
    }
}
