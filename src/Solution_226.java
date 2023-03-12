/**
 * @author by zling
 * @classname Solution_226
 * @description TODO
 * @date 2023/3/12 22:16
 */
public class Solution_226 {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left != null || root.right != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            this.invertTree(root.left);
            this.invertTree(root.right);
        }
        return root;
    }




    public static void main(String[] args) {

        Solution_226 solution_226 = new Solution_226();
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, node3);

        solution_226.invertTree(node2);


    }




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




}
