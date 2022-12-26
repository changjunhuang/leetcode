package tree;

import pub.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 */
public class 二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        bef(root,list);
        return list;
    }

    public static void bef(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        bef(root.left,list);
        bef(root.right,list);
        list.add(root.val);
    }
}
