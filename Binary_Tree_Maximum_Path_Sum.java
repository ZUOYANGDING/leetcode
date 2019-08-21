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
    private int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        findSolution(root);
        return maxValue;
    }
    
    private int findSolution(TreeNode root) {
        if (root == null)  {
            return 0;
        }
        int left = Math.max(0, findSolution(root.left));
        int right = Math.max(0, findSolution(root.right));
        // this maxValue is a mark for the largest path sum's root
        // Sometimes this path contains negative node, however, its ancient node is large enough
        // to make this negative node be include into the path. Therefore, the return value for
        // the recursion should include the current node.
        maxValue = Math.max(maxValue, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}