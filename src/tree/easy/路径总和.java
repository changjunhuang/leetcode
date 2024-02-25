package tree.easy;

import pub.TreeNode;

/**
 * 112. 路径总和
 *
 * @author huangchangjun
 * @date 2024/2/24
 */
public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    // 自己实现
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null ) {
            return false;
        }
        int newSum = targetSum - root.val;
        if (newSum == 0 && root.left == null && root.right == null) {
            return true;
        }

        boolean leftFlag = hasPathSum2(root.left, newSum);
        boolean rightFlag = hasPathSum2(root.right, newSum);
        return leftFlag || rightFlag;
    }
}
