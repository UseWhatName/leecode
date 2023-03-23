import java.util.List;

/**
 * @author by zling
 * @classname Solution_114
 * @description TODO
 * @date 2023/3/23 22:14
 */
public class Solution_114 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public void flatten(TreeNode root) {

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }


    public static void main(String[] args) {
        Solution_114 solution_114 = new Solution_114();
        TreeNode treeNode = new TreeNode();
        solution_114.flatten(treeNode);



    }


}
