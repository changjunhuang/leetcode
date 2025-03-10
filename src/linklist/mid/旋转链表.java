package linklist.mid;

import pub.ListNode;

/**
 * 61. 旋转链表
 *
 * @author huangchangjun
 * @date 2024/2/24
 */
public class 旋转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = rotateRight(head, 12);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        // 初始数据
        ListNode pre = head;
        int step = 1;

        // 循环到最后一个节点
        while (pre.next != null) {
            pre = pre.next;
            step = step + 1;
        }
        // 形成循环链表
        pre.next = head;
        // 简化计算次数
        k = k % step;

        for (int i = 0; i < step - k; i++) {
            if (i == step - k - 1) {
                ListNode temp = head.next;
                head.next = null;
                head = temp;
                break;
            }
            head = head.next;
        }
        return head;
    }
}
