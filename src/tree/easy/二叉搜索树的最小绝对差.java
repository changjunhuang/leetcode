package tree.easy;

import pub.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 * TODO 未完成所有用例
 */
public class 二叉搜索树的最小绝对差 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(5);
        node.right.left = new TreeNode(3);

        System.out.println(getMinimumDifference(node));

    }

    static Integer minNum;

    public static int getMinimumDifference(TreeNode root) {
        minNum = Integer.MAX_VALUE;
        getMinimum(root);
        return minNum;
    }

    public static int getMinimum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        if (root.left != null) {
            int left = getMinimum(root.left);
            //  根值 - 左子节点的值
            getMin(root.val - left);
        }
        if (root.right != null) {
            int right = getMinimum(root.right);
            //  右子节点的值 - 根值
            getMin(right - root.val);
        }
        if (root.right != null) {
            return root.right.val;
        }
        return root.val;
    }

    public static void getMin(int val) {
        if (val < minNum) {
            minNum = val;
        }
    }
}
