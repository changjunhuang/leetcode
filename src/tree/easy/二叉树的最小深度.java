package tree.easy;

import pub.TreeNode;

/**
 * 111. 二叉树的最小深度
 */
public class 二叉树的最小深度 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);

        System.out.println(minDepth(root));
    }

    static int minPath = Integer.MAX_VALUE;

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        //  单支树的情况，就是某个节点只有左节点或只有右节点
        if (root.left == null || root.right == null) {
            return left + right + 1;
        }
        //  分两种情况返回
        return (left <= right ? left : right) + 1;
    }

}
