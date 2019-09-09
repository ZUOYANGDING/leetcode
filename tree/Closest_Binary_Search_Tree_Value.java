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
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return res;
        }
        res = root.val;
        findSolution(root, target);
        return res;
    }
    
    public void findSolution(TreeNode root, double target) {
        if (root==null) {
            return;
        }
        findSolution(root.left, target);
        if (Math.abs(root.val-target) < Math.abs(res-target)) {
            res = root.val;
        }
        findSolution(root.right, target);
    }
}