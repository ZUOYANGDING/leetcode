// Same idea as Binary tree level order traversal, but use a flag to mark if push left first or right
// first

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> parent = new Stack<>();
        parent.push(root);
        int flag = -1;
        while (!parent.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> children = new Stack<>();
            while (!parent.isEmpty()) {
                TreeNode node = parent.pop();
                if (node != null) {
                    list.add(node.val);
                    if (flag < 0) {
                        children.push(node.left);
                        children.push(node.right);
                    } else {
                        children.push(node.right);
                        children.push(node.left);
                    }
                    
                }
            }
            flag *= -1;
            if (!list.isEmpty()) {
                res.add(list);
            }
            parent = children;
        }
        return res;
    }
}