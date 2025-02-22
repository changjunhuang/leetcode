package tree.easy;

import pub.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 * @author huangchangjun
 * @date
 */
public class 叶子相似的树 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        getLeafNode(root1,list1);
        getLeafNode(root2,list2);

        return list1.equals(list2);
    }

    private void getLeafNode(TreeNode root,List<Integer> list){
        if(root == null){
            return ;
        }

        if(root.left ==null && root.right == null){
            list.add(root.val);
        }

        getLeafNode(root.left,list);
        getLeafNode(root.right,list);

    }
}
