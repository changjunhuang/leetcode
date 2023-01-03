package tree.easy;

import pub.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 左根右
 */
public class 二叉树的中序遍历 {

    private  List<Integer> array = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return this.array;
        }

        inorderTraversal(root.left);
        array.add(root.val);
        inorderTraversal(root.right);
        return this.array;
    }
}
