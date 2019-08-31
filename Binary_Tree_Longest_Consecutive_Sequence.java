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
    public int longestConsecutive(TreeNode root) {    
        if (root==null) {
            return 0;
        }
        res = 0;
        findSolution(root);
        return res;
    }
    
    public int findSolution(TreeNode root) {
        if (root.left==null && root.right==null) {
            res = Math.max(1, res);
            return 1;
        }
        int left=1, right=1;
        if (root.left != null) {
            left = findSolution(root.left);
            if (root.val-root.left.val==-1) {
                left++;
            } else {
                // recount the length
                left = 1;
            }
        }
        if (root.right != null) {
            right = findSolution(root.right);
            if (root.val-root.right.val==-1) {
                right++;
            } else {
                // recount the length
                right = 1;
            }
        }
        res = Math.max(left, Math.max(right, res));
        return Math.max(left, right);
    }
    
}