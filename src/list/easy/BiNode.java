package list.easy;

import pub.TreeNode;

/**
 * 面试题 17.12. BiNode
 * 未能理解
 */
public class BiNode {
    /**
     * 为了返回单向链表的头节点而多设的一个节点
     */
    TreeNode head = new TreeNode(-1);
    /**
     * 指向当前节点的前一个节点
     */
    TreeNode perv = null;

    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return head.right;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        // 第一个节点
        if (perv == null) {
            // 记录第一个节点
            perv = root;
            // 记录它，它将作为单链表的表头
            head.right = root;
        } else {
            // 第一个节点之后的节点
            // 前一个节点的右指针指向当前节点
            perv.right = root;
            // 更新perv指向
            perv = root;
        }
        // 当前节点的左指针设为null
        root.left = null;
        helper(root.right);
    }
}
