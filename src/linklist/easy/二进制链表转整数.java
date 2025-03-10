package linklist.easy;

import pub.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1290. 二进制链表转整数
 */
public class 二进制链表转整数 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);

        System.out.println(getDecimalValue(node));
    }

    public static int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        //  1 1 0 1   8 4 0 1  8 4 2 1
        int result = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == 1) {
                result = result + getMi(list.size() - 1 - i);
            }
        }
        return result;
    }

    public static int getMi(int k) {
        int result = 1;
        for (int i = 0; i < k; i++) {
            result = result * 2;
        }
        return result;
    }
}
