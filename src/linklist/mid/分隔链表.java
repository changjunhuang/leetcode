package linklist.mid;

import pub.ListNode;

/**
 * 86. 分隔链表
 */
public class 分隔链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode result = partition(head, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }


    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode minHead = null;
        int minFlag = 0;
        ListNode maxHead = null;
        int maxFlag = 0;
        ListNode startMinHead = null;
        ListNode startMaxHead = null;

        while (head != null) {
            if (head.val < x) {
                minFlag++;
                if (minFlag == 1) {
                    minHead = head;
                    startMinHead = minHead;
                } else {
                    minHead.next = head;
                    minHead = head;
                }
                head = head.next;
                minHead.next = null;
            } else {
                maxFlag++;
                if (maxFlag == 1) {
                    maxHead = head;
                    startMaxHead = maxHead;
                } else {
                    maxHead.next = head;
                    maxHead = head;
                }
                head = head.next;
                maxHead.next = null;
            }
        }
        if (startMinHead != null) {
            minHead.next = startMaxHead;
            return startMinHead;
        }
        return startMaxHead;
    }

    //  leetcode官解，非常清晰简洁
    public ListNode partition2(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
