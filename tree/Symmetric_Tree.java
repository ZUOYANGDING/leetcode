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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return findSolution(root.left, root.right);
    }
    
    public boolean findSolution(TreeNode left, TreeNode right) {
        // key line
        if (left==null || right==null) {
            return (left==right);
        }
        if (left.val != right.val) {
            return false;
        }
        return (findSolution(left.left, right.right) && findSolution(left.right, right.left));
        
    }
}