package linklist.mid;

import pub.ListNode;

/**
 * 143. 重排链表
 */
public class 重排链表 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        reorderList(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 1、找链表中点
     * 2、反转后边链表
     * 3、进行链表合并
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        //  找中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode slowHead = mid.next;
        mid.next = null;

        //  反转后边的链表
        ListNode reverse = reverseList(slowHead);

        //  链表合并
        ListNode temp = head;
        ListNode tempNext = head;
        ListNode reverseNext = reverse;
        while (tempNext != null && reverseNext != null) {
            tempNext = tempNext.next;
            reverseNext = reverseNext.next;

            temp.next = reverse;
            reverse.next = tempNext;

            temp = tempNext;
            reverse = reverseNext;
        }
    }

    //  反转链表
    public static ListNode reverseList(ListNode head) {
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
