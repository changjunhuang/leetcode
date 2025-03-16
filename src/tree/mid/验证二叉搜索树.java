package tree.mid;

import pub.TreeNode;

/**
 * 98. 验证二叉搜索树
 *
 * @author huangchangjun
 * @date 2025-03-16
 */
public class 验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        return valid(root, min, max);
    }

    private static boolean valid(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        boolean left = valid(node.left, min, node.val);
        boolean right = valid(node.right, node.val, max);
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return left && right;
    }
}
