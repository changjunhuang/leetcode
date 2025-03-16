package tree.easy;

import pub.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
 *
 * @author huangchangjun
 * @date 2025-03-16
 */
public class 有序链表转换二叉搜索树 {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    public static TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }
}
