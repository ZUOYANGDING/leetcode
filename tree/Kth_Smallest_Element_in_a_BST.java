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
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> s = new Stack<>();
        while (root!=null || !s.isEmpty()) {
            while (root!=null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            count++;
            if (count == k) {
                return root.val;
            } else {
                root = root.right;
            }
        }
        return -1;
    }
}