/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int res;
    public int sumNumbers(TreeNode root) {
        res = 0;
        if (root == null) {
            return res;
        }
        String s = "";
        findSolution(root, s);
        return res;
    }
    
    public void findSolution(TreeNode root, String s) {
        if (root.left==null && root.right==null) {
            s += root.val;
            res += Integer.parseInt(s);
            return;
        }
        s += root.val;
        if (root.left != null) {
            findSolution(root.left, s);
        }
        if (root.right != null) {
            findSolution(root.right, s);
        }
    }
}