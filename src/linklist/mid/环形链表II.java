package linklist.mid;

import pub.ListNode;

/**
 * 142. 环形链表 II
 *
 * @author huangchangjun
 * @date 2025-03-14
 */
public class 环形链表II {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        System.out.println(detectCycle(node));
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fp = head;
        ListNode sp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            //判断是否成环
            if (fp == sp) {
                break;
            }
        }
        // 数据非环情况下，如果fp到达最后一个节点，那么就返回null
        if (fp == null || fp.next == null) {
            return null;
        }

        //fp到环入口距离 = head到环入口距离
        sp = head;
        while (fp != sp) {
            sp = sp.next;
            fp = fp.next;
        }
        return sp;
    }
}
