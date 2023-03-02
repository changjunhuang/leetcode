package list.easy;

import pub.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        //如果链表为空或者链表中只有一个元素
        //用来控制从倒数第二个节点开始就反转
        if (head == null || head.next == null) {
            return head;
        } else {
            //先反转后面的链表，走到链表的末端结点
            ListNode newhead = reverseList(head.next);
            //再将当前节点设置为后面节点的后续节点
            head.next.next = head;
            head.next = null;

            return newhead;
        }
    }
}
