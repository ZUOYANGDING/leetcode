/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// For a non-leaf node, the longest path is increasing from left nodes to right nodes
// or decreasing from left node to right nodes. Therefore, travel the BT in preorder, and
// check every node's longest path in preorder (root to leaf, choose max from left and right). 
class Solution {
    public int longestConsecutive(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        res = 1 + findSolution(root, 1) + findSolution(root, -1);
        return Math.max(res, Math.max(longestConsecutive(root.left), longestConsecutive(root.right)));
    }
    
    public int findSolution(TreeNode root, int flag) {
        if (root == null) {
            return 0;
        }
        int left=0, right=0;
        if (root.left != null && root.val-root.left.val==flag) {
            left = 1 + findSolution(root.left, flag);
        }
        if (root.right != null && root.val-root.right.val==flag) {
            right = 1 + findSolution(root.right, flag);
        }
        return Math.max(left, right);
    }
}