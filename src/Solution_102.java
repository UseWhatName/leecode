import java.util.ArrayList;
import java.util.List;

/**
 * @author by zling
 * @classname Solution_102
 * @description TODO
 * @date 2023/3/5 15:21
 */
public class Solution_102 {

    /**
    * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode() {}
    *     TreeNode(int val) { this.val = val; }
    *     TreeNode(int val, TreeNode left, TreeNode right) {
    *         this.val = val;
    *         this.left = left;
    *         this.right = right;
    *     }
    * }
    */

    public static void main(String[] args) {
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);
        Solution_102 solution_102 = new Solution_102();
        List<List<Integer>> lists = solution_102.levelOrder(treeNode3);
        System.out.println(lists);
    }




    public Solution_102() {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> roots = new ArrayList<>();
        roots.add(root);
        List<List<Integer>> ret = new ArrayList<>();
        List<TreeNode> nextLeveTreeNodes = roots;
        while (nextLeveTreeNodes.size() > 0) {
            nextLeveTreeNodes = this.getNextNodes(nextLeveTreeNodes, ret);
        }
        return ret;


    }


    public List<TreeNode> getNextNodes(List<TreeNode> nodes, List<List<Integer>> ret) {
        List<TreeNode> nextLeveNodes = new ArrayList<>();
        List<Integer> curRow = new ArrayList<>();
        for (int i = 0; i < nodes.size(); ++i) {
            curRow.add(nodes.get(i).val);
            if (nodes.get(i).left != null) {
                nextLeveNodes.add(nodes.get(i).left);
            }
            if (nodes.get(i).right != null) {
                nextLeveNodes.add(nodes.get(i).right);
            }
        }
        ret.add(curRow);
        return nextLeveNodes;
    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
