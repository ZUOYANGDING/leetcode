/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// travel inorder on left most, then travel to all leaves in this tree, then travel postorder 
// on right most. When travel left, always go left if left exist, else go right. When travel right,
// always go right if right exist, else go left.
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (root==null) {
            return res;
        }
        list.add(root);
        travelLeft(root.left, list);
        travelMid(root, list);
        travelRight(root.right, list);
        for (TreeNode node : list) {
            res.add(node.val);
        }
        return res;
    }
    
    public void travelLeft(TreeNode root, List<TreeNode> list) {
        if (root==null) {
            return;
        }
        list.add(root);
        if (root.left != null) {
            travelLeft(root.left, list);
        } else {
            travelLeft(root.right, list);
        }
    }
    
    public void travelMid(TreeNode root, List<TreeNode> list) {
        if (root.left==null && root.right==null) {
            if (!list.contains(root)) {
                list.add(root);
                return;
            } else {
                return;
            }
        }
        if (root.left != null) {
            travelMid(root.left, list);
        }
        if (root.right != null) {
            travelMid(root.right, list);
        }
        
    }
    
    public void travelRight(TreeNode root, List<TreeNode> list) {
        if (root==null) {
            return;
        }
        if (root.right != null) {
            travelRight(root.right, list);
        } else {
            travelRight(root.left, list);
        }
        if (!list.contains(root)) {
            list.add(root);
        }
    }
}