/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
Easy way to solve this problem is, that traverse the tree inorder, apply 2 list: one to store node
and another one to store value of the node. Sort the list storing node value, then provide the sorted
value to each node. This way cost space O(n), but works for more than 2 nodes swaped.
*/
class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> node_list = new ArrayList<>();
        List<Integer> val_list = new ArrayList<>();
        inorderTravel(root, node_list, val_list);
        Collections.sort(val_list);
        int index = 0;
        for (TreeNode node : node_list) {
            node.val = val_list.get(index);
            index++;
        }
    }
    
    public void inorderTravel(TreeNode root, List<TreeNode> node_list, List<Integer> val_list) {
        if (root==null) {
            return;
        }
        inorderTravel(root.left, node_list, val_list);
        node_list.add(root);
        val_list.add(root.val);
        inorderTravel(root.right, node_list, val_list);
    }
}