import org.w3c.dom.Node;
import pub.TreeNode;

import java.util.*;

/**
 * @author huangchangjun
 * @date
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(8);

//        System.out.println(sortedArrayToBST(root, 4));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return sortMid(nums, 0, nums.length - 1);
    }


    private static TreeNode sortMid(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = (right + left) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        TreeNode leftNode = sortMid(nums, left, mid - 1);
        TreeNode rightNode = sortMid(nums, mid + 1, right);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}