package list.easy;

import pub.ListNode;

/**
 * 面试题 02.03. 删除中间节点
 */
public class 删除中间节点 {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
