/*
Apply inorder traversal. During the process, if the number of nodes approached less than k, keep
traversal; if have already approached k nodes, compare the current node and the first approached node.
if current is more closet, erase the first node, add the current in, if not, return the list (since inorder
traversal in a BST return the value inorder, the node approached less then the next node will approach. Therefore,
if the current node is far than the first one, the next ones cannot be closer).
*/

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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while (root!=null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (list.size() < k) {
                list.add(root.val);
                root = root.right;
            } else {
                if (Math.abs(root.val-target) < Math.abs(list.get(0) - target)) {
                    list.remove(0);
                    list.add(root.val);
                    root = root.right;
                } else {
                    return list;
                }
            } 
        }
        return list;
    }
}