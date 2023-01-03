package tree.easy;

import pub.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 搜索树，左小右大特性
 */
public class 二叉搜索树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        if (p.val > root.val && q.val > root.val) {
            node = lowestCommonAncestor(root.right, p, q);
        }
        if (p.val < root.val && q.val < root.val) {
            node = lowestCommonAncestor(root.left, p, q);
        }
        return node;
    }
}
