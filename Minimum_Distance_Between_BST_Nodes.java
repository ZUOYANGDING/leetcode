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
    private int min;
    TreeNode pre;
    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = new TreeNode(Integer.MAX_VALUE);
        pre.left = root;
        findSolution(root);
        return min;
    }
    
    public void findSolution(TreeNode root) {
        if (root == null) {
            return;
        }
        findSolution(root.left);
        min = (Math.abs(root.val - pre.val) < min) ? (Math.abs(root.val - pre.val)) : min;
        pre = root;
        findSolution(root.right);
    }
}