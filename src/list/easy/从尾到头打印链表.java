package list.easy;

import pub.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 */
public class 从尾到头打印链表 {

//    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(3);
//        head.next.next = new ListNode(2);
//
//        int[] array = reversePrint(head);
//
//    }

    public static void main(String[] args) {
        String str1 = "3";
        String str2 = "3";

        int result = str1.compareTo(str2);
        System.out.println(result);
    }


    public static int[] reversePrint(ListNode head) {

        List<Integer> listNodes = new ArrayList<>();
        ListNode temp = reversalListNode(listNodes, head);
        if (temp != null) {
            listNodes.add(temp.val);
        }

        int[] array = new int[listNodes.size()];

        int i = 0;
        for (Integer val : listNodes) {
            array[i++] = val;
        }

        return array;
    }

    private static ListNode reversalListNode(List<Integer> listNodes, ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode temp = reversalListNode(listNodes, node.next);
        if (temp != null) {
            listNodes.add(temp.val);
        }
        return node;
    }
}
