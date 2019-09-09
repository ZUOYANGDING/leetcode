/*
Apply postorder traversal on original BT, and build a new tree in the process. Addtionally, use a
dummy node to mark the 1st level root of the new tree.
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
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode res = new TreeNode(-1);
        buildTree(root, res);
        return res.right;
    }
    
    public TreeNode buildTree(TreeNode root, TreeNode res) {
        if (root.left==null && root.right==null) {
            TreeNode leaf = new TreeNode(root.val);
            if (res.right == null) {
                res.right = leaf;
            }
            return leaf;
        }
        TreeNode left=null, right=null;
        if (root.left != null) {
            left = buildTree(root.left, res);
        }
        if (root.right != null) {
            right = buildTree(root.right, res);
        }
        TreeNode new_root = new TreeNode(root.val);
        left.left = right;
        left.right = new_root;
        if (res.right == null) {
            res.right = left;
        }
        return new_root;
    }
}