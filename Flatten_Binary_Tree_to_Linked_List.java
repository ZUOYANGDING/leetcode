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
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        helper(root, list);
        for (int i=0; i<list.size()-1; i++) {
            TreeNode temp = list.get(i);
            temp.left = null;
            temp.right = list.get(i+1);
        }
    }
    
    public void helper(TreeNode root, List<TreeNode> list) {
        if (root==null) {
            return;
        }
        list.add(root);
        helper(root.left, list);
        helper(root.right, list);
    }
}