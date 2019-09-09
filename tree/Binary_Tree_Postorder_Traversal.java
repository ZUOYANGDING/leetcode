/*
Set a mark pointer to mark the previous node whose val has already been add into the return list.
For any node, if its left/right child's val has been added into return list, or left and right child
are both null, we can add the node's val into return list and pop it out from stack. Since here we want
post order traversal and apply stack, we need to add right child first then left child.
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root == null){
            return res;
        }
        s.push(root);
        TreeNode pre = root;
        while (!s.isEmpty()) {
            root = s.peek();
            if ((root.left==null && root.right==null) || root.left==pre || root.right==pre) {
                s.pop();
                res.add(root.val);
                pre = root;
            } else {
                if (root.right!=null) {
                    s.push(root.right);
                }
                if (root.left!=null) {
                    s.push(root.left);
                }
            }
        }
        return res;
    }
}