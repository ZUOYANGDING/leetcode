/*
Apply postorder traversal on the BT
*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int count;
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        if (root == null) {
            return count;
        }
        findSolution(root);
        return count;
    }
    
    public boolean findSolution(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = findSolution(root.left);
        boolean right = findSolution(root.right);
        if (left && right) {
            if ((root.left!=null && root.left.val!=root.val) || (root.right!=null &&               root.right.val!=root.val)) {
                return false;
            } else {
                count++;
                return true;
            }
        }
        return false;
    }
}