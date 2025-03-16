package linklist.hard;

import pub.ListNode;

/**
 * 23. 合并 K 个升序链表
 *
 * @author huangchangjun
 * @date 2025-03-15
 */
public class 合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        //步数
        int trade = 1;
        while (trade <= lists.length) {
            //合并指定步数链表
            for (int i = 0; i < lists.length; i = i + trade * 2) {
                if (i + trade < lists.length) {
                    lists[i] = merge(lists[i], lists[i + trade]);
                }
            }
            //位运算 1，3，7 增加归并步
            trade = trade << 1;
        }
        return lists[0];
    }

    //  轮询合并，时间复杂度高，但最直观
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = merge(ans, lists[i]);
        }
        return ans;
    }

    //合并双链表
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = merge(l1.next, l2);
        } else {
            head = l2;
            head.next = merge(l1, l2.next);
        }
        return head;
    }
}
