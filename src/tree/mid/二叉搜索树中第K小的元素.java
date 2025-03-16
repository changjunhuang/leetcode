package tree.mid;

import pub.TreeNode;

/**
 * 230. 二叉搜索树中第 K 小的元素
 *
 * @author huangchangjun
 * @date 2025-03-16
 */
public class 二叉搜索树中第K小的元素 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        System.out.println(kthSmallest(root, 1));
    }

    public static int target = 0;
    public static int step = 0;

    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        target = 0;
        step = 0;
        find(root, k);
        return target;
    }

    public static void find(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        find(root.left, k);
        step = step + 1;
        if (step == k) {
            target = root.val;
        }
        find(root.right, k);
    }
}
