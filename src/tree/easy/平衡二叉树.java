package tree.easy;

import pub.TreeNode;

/**
 * 110. 平衡二叉树
 */
public class 平衡二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);

        System.out.println(isBalanced(root2));
    }

    static Boolean flag;

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        flag = true;
        right(root);
        return flag;
    }

    public static int right(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int currentNum = 1;
        int left = currentNum + right(root.left);
        int right = currentNum + right(root.right);

        if (left - right >= 2 || right - left >= 2) {
            flag = false;
        }

        return left >= right ? left : right;
    }
}

