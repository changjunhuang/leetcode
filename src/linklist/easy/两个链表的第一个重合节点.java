package linklist.easy;

import pub.ListNode;

/**
 * 剑指 Offer II 023. 两个链表的第一个重合节点
 */
public class 两个链表的第一个重合节点 {
    //  双指针法
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        //  互换走一个轮回后，两个指针所走节点数量必然相同；如果两个节点不相交，必定会同时为Null
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
