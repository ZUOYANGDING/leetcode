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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> parent = new LinkedList<>();
        parent.add(root);
        while (!parent.isEmpty()) {
            Queue<TreeNode> children = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            for (TreeNode node : parent) {
                if (node != null) {
                    list.add(node.val);
                    children.add(node.left);
                    children.add(node.right);
                }
            }
            if (!list.isEmpty()) {
                res.add(list);
            }
            parent = children;
        }
        return res;
    }
    
}