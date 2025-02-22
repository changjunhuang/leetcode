package tree.easy;

import pub.TreeNode;

/**
 * LCR 175. 计算二叉树的深度
 * @author huangchangjun
 * @date
 */
public class 计算二叉树的深度 {

    public int maxDepth(TreeNode root) {
        return getMaxDepth(root);
    }

    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int currentDepth = 1;
        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);

        return (leftDepth > rightDepth ? leftDepth : rightDepth) + currentDepth;
    }
}
