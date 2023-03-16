package list.mid;

import pub.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class 两两交换链表中的节点 {
    public static void main(String[] args) {

    }

    //  递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    //  迭代，好理解
    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

}
