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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        while (temp!=null || !s.isEmpty()) {
            while (temp!=null) {
                res.add(temp.val);
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            temp = temp.right;
        }
        return res;
    }
}