package tree;

import pub.TreeNode;

/**
 * 404. 左叶子之和
 */
public class 左叶子之和 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(2);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(1);
        node.left.left.left = new TreeNode(5);
        node.left.left.right = new TreeNode(1);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(-1);
        node.right.left.right = new TreeNode(6);
        node.right.right.right = new TreeNode(8);

        System.out.println(sumOfLeftLeaves(node));

    }

    static Integer result = 0;

    public static int sumOfLeftLeaves(TreeNode root) {
        //  排除只有根节点的情况
        if (root.left == null && root.right == null) {
            return 0;
        }
        result = 0;
        getLeftLeaf(root, true);
        return result;
    }

    public static void getLeftLeaf(TreeNode node, Boolean flag) {
        if (node.left == null && node.right == null && flag == true) {
            result = result + node.val;
            return;
        }
        if (node.left == null && node.right == null && flag == false) {
            return;
        }
        //  左叶子
        if (node.left != null) {
            getLeftLeaf(node.left, true);
        }
        //  右叶子
        if (node.right != null) {
            getLeftLeaf(node.right, false);
        }
        return;
    }
}
