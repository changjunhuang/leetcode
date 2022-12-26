package list;

import pub.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 */
public class 移除重复节点 {
    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(3);
//        node.next.next.next.next = new ListNode(2);
//        node.next.next.next.next.next = new ListNode(1);

        ListNode result = removeDuplicateNodes(node);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }

        Set nodeSet = new HashSet();
        ListNode left = head;
        ListNode right = head;
        while (right != null) {
            //  新的节点，保存进set集合中，后面做判断
            if (!nodeSet.contains(right.val)) {
                nodeSet.add(right.val);
                if (left == right) {
                    right = right.next;
                } else {
                    right = right.next;
                    left = left.next;
                }
                continue;
            }

            //  包含重复的节点,跳过
            left.next = right.next;
            right = right.next;
        }
        left.next = null;
        return head;
    }
}
