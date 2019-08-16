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
    public boolean isValidBST(TreeNode root) {
        if (root==null) {
            return true;
        }  
        Stack<TreeNode> s = new Stack<>();
        double pre = - Double.MAX_VALUE;
        TreeNode temp = root;
        while (temp!=null || !s.isEmpty()) {
            while (temp!=null) {
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            if (temp.val <= pre) {
                return false;
            }
            pre = temp.val;
            temp = temp.right;
        }
        return true;
        
    }
    
}