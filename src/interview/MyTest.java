package interview;

import pub.ListNode;

import java.util.HashMap;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(1);
        node2.next.next = new ListNode(1);
        node2.next.next.next = new ListNode(2);
        node2.next.next.next.next = new ListNode(3);

        ListNode result = getNewList(node);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        System.out.println("/n");

        ListNode result2 = getNewList(node2);
        while (result2 != null) {
            System.out.println(result2.val);
            result2 = result2.next;
        }
    }


    public static ListNode getNewList(ListNode node) {
        if (node == null) {
            return node;
        }

        Map<Integer, Integer> map = new HashMap<>();
        ListNode pre = node;
        while (pre != null) {
            if (map.containsKey(pre.val)) {
                int num = map.get(pre.val);
                map.put(pre.val, num + 1);
            } else {
                map.put(pre.val, 1);
            }
            pre = pre.next;
        }

        ListNode preHead = new ListNode(-1);
        preHead.next = node;
        ListNode temp = preHead;
        while (temp.next != null) {
            int num = map.get(temp.next.val);
            if (num > 1) {
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        return preHead.next;
    }
}
