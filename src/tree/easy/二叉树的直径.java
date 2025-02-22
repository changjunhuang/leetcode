package tree.easy;

import pub.TreeNode;

/**
 * 543. 二叉树的直径
 *
 * @author huangchangjun
 * @date
 */
public class 二叉树的直径 {

    public static int max;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = 0;
        int temp = dfs(root);
        return temp == 1 ? 0 : max - 1;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        int currentNode = left + right + 1;
        max = Math.max(max, currentNode);
        return Math.max(left, right) + 1;
    }
}
