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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null) {
            return false;
        }
        return findSolution(root, sum, 0);  
    }
    
    public boolean findSolution(TreeNode root, int target, int n) {
        if (root.left==null && root.right==null) {
            if (n+root.val == target) {
                return true;
            } else {
                return false;
            }
        }
        n = n + root.val;
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = findSolution(root.left, target, n);
        }
        if (root.right != null) {
            right = findSolution(root.right, target, n);
        }
        return (left || right);
    }
}