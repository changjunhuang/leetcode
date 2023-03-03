package list.easy;

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

        System.out.println(middleNode(listNode1));
    }

    public static int resultNum = 0;
    public static int num = 0;
    public static ListNode listNode = null;

    private static ListNode middleNode(ListNode head) {
        if (head == null) {
            resultNum = num;
            return head;
        }
        num++;
        middleNode(head.next);

        if (num % 2 == 0) {
            if (resultNum == num / 2) {
                listNode = head.next;
            }
        } else {
            if (resultNum == (num / 2) + 1) {
                listNode = head;
            }
        }
        resultNum--;

        return listNode;
    }
}
