package tree.mid;

import pub.TreeNode;

/**
 * 437. 路径总和 III
 *
 * @author huangchangjun
 * @date 2025-03-17
 */
public class 路径总和III {
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        // 以当前节点为根节点的路径数量
        int currentNum = rootSum(root, targetSum);
        // 以左节点为根节点的路径数量
        int leftNum = pathSum(root.left, targetSum);
        // 以右节点为根节点的路径数量
        int rightNum = pathSum(root.right, targetSum);
        return currentNum + leftNum + rightNum;
    }

    // 以root为根节点的路径数量
    public int rootSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int num = 0;
        int val = root.val;
        if (val == targetSum) {
            num++;
        }

        num = num + rootSum(root.left, targetSum - val);
        num = num + rootSum(root.right, targetSum - val);
        return num;
    }
}