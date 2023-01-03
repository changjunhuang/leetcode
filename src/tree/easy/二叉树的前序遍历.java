package tree.easy;

import pub.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 */
public class 二叉树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        pre(root,list);
        return list;
    }

    public static void pre(TreeNode root,List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        pre(root.left,list);
        pre(root.right,list);
    }
}
