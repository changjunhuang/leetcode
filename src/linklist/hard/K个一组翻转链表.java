package linklist.hard;

import pub.ListNode;


/**
 * 25. K 个一组翻转链表
 *
 * @author huangchangjun
 * @date 2025-03-15
 */
public class K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        // 创建虚节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 每一组的前缀节点
        ListNode preGroup = dummy;
        while (true) {
            // 每一组的开始节点
            ListNode start = preGroup.next;
            // 获取每一组的结束节点
            ListNode end = start;
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            // 如果不足k个节点，则停止
            if (end == null) {
                break;
            }
            // 记录下一组的开始节点
            ListNode nextStart = end.next;
            // 断裂与下一组的连接
            end.next = null;
            // 反转当前组
            ListNode currGroup = reverse(start);
            // 将当前组与前缀节点连接
            preGroup.next = currGroup;
            // 连接下一组，start已经变为end
            start.next = nextStart;
            // 更新下一组的前缀节点
            preGroup = start;
        }
        return dummy.next;
    }

    // 反转链表
    public ListNode reverse(ListNode head) {
        //如果链表为空或者链表中只有一个元素
        //用来控制从倒数第二个节点开始就反转
        if (head == null || head.next == null) {
            return head;
        } else {
            //先反转后面的链表，走到链表的末端结点
            ListNode newhead = reverse(head.next);
            //再将当前节点设置为后面节点的后续节点
            head.next.next = head;
            head.next = null;
            return newhead;
        }
    }
}