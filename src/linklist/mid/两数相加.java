package linklist.mid;

import pub.ListNode;

/**
 * 2. 两数相加
 *
 * @author huangchangjun
 * @date 2025-03-15
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = null;
        ListNode result = null;

        //进位符
        int carry = 0;
        //遍历两个list node ; 自动填充空缺
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            //取 进位数
            carry = sum / 10;

            //取模拿节点
            ListNode node = new ListNode(sum % 10);
            if (tmp == null) {
                tmp = node;
                result = tmp;
            } else {
                tmp.next = node;
                tmp = tmp.next;
            }

            //遍历链表
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return result;
    }
}
