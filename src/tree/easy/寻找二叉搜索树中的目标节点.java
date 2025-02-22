package tree.easy;

import pub.TreeNode;

/**
 * LCR 174. 寻找二叉搜索树中的目标节点
 *
 * @author huangchangjun
 * @date
 */
public class 寻找二叉搜索树中的目标节点 {
    public static int nodeNum = 0;
    public static int targtValue = 0;

    public static int findTargetNode(TreeNode root, int cnt) {
        nodeNum = 0;
        targtValue = 0;
        if (root == null) {
            return 0;
        }
        findTargetNode2(root, cnt);
        return nodeNum;
    }

    public static void findTargetNode2(TreeNode root, int cnt) {
        if (root == null) {
            return;
        }

        findTargetNode2(root.right, cnt);
        targtValue = targtValue + 1;
        if (targtValue == cnt) {
            nodeNum = root.val;
        }
        findTargetNode2(root.left, cnt);
    }
}
