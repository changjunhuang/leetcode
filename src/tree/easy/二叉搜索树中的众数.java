package tree.easy;

import pub.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 */
public class 二叉搜索树中的众数 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
//        root.right = new TreeNode(2);

        二叉搜索树中的众数 num = new 二叉搜索树中的众数();
        int[] x = num.findMode(root);
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }

    public int[] findMode(TreeNode root) {

        getMode(root);
        //  数组初始化时要指定数组大小，长度不是动态的
        int[] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    List<Integer> list = new ArrayList<>();
    static int temp = -1;
    static int currentNum = 0;
    static int maxNum = 0;

    public void getMode(TreeNode root) {
        if (root == null) {
            return;
        }
        getMode(root.left);

        if (root.val != temp) {
            temp = root.val;
            currentNum = 1;
        } else {
            currentNum++;
        }

        if (currentNum == maxNum) {
            list.add(temp);
        }
        if (currentNum > maxNum) {
            list.clear();
            list.add(temp);
            maxNum = currentNum;
        }

        getMode(root.right);
    }
}
