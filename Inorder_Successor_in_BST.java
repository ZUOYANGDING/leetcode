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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> s = new Stack<>();
        while (root!=null || !s.isEmpty()) {
            while (root!=null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (root.val > p.val) {
                return root;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}