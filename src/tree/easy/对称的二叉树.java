package tree.easy;

import pub.TreeNode;

/**
 * 剑指 Offer 28. 对称的二叉树
 */
public class 对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        //  用下面的代替
//        if (left == null || right == null) {
//            return false;
//        }
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        //  左右两节点相等时正左右为true，不等时，上面的校验会返回false，不会往下走
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
