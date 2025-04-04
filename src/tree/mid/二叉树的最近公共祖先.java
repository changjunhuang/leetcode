package tree.mid;

import pub.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 *
 * @author huangchangjun
 * @date 2025-03-17
 */
public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //发现目标节点则通过返回值标记该子树发现了某个目标结点
        if (root == null || root == p || root == q) {
            return root;
        }
        //查看左子树中是否有目标结点，没有为null
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //查看右子树是否有目标节点，没有为null
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //都不为空，说明做右子树都有目标结点，则公共祖先就是本身
        if (left != null && right != null) {
            return root;
        }
        //如果发现了目标节点，则继续向上标记为该目标节点
        return left == null ? right : left;
    }
}
