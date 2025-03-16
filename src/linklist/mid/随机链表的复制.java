package linklist.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 随机链表的复制
 *
 * @author huangchangjun
 * @date 2025-03-15
 */
public class 随机链表的复制 {
    public static void main(String[] args) {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node0.next = node1;
        node0.random = null;

        node1.next = node2;
        node1.random = node0;

        node2.next = node3;
        node2.random = node4;

        node3.next = node4;
        node3.random = node2;

        node4.next = null;
        node4.random = node0;

        Node result = copyRandomList(node0);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node result = new Node(-1);
        Node temp = result;
        // <旧的，新的>
        Map<String, Node> map = new HashMap<>();
        Node preHead = head;

        while (preHead != null) {
            Node newNode = new Node(preHead.val);
            map.put(preHead.toString(), newNode);
            preHead = preHead.next;
        }

        while (head != null) {
            Node randomNode = null;
            if (head.random != null) {
                randomNode = map.get(head.random.toString());
            }
            temp.next = map.get(head.toString());
            temp.next.random = randomNode;
            temp = temp.next;
            head = head.next;
        }

        return result.next;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
