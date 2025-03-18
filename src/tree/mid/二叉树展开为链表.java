package tree.mid;

import pub.TreeNode;

/**
 * 114. 二叉树展开为链表
 * @author huangchangjun
 * @date 2025-03-17
 */
public class 二叉树展开为链表 {

    private TreeNode preNode = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = preNode;
        preNode = root;
    }
}
