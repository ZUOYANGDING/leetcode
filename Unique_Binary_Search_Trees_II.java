/*
Apply divide and conqure. Choose the each number from 1 to n as the root, and the left numbers
as left subtree, the right number as right subtree. Build the tree recursively, 
then combine the results.
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
    public List<TreeNode> generateTrees(int n) {
        if (n<=0) {
            return (new ArrayList<TreeNode>());
        }
        return findSolution(1, n);
    }
    
    public List<TreeNode> findSolution(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        List<TreeNode> left_list;
        List<TreeNode> right_list;
        for (int i=left; i<=right; i++) {
            left_list = findSolution(left, i-1);
            right_list = findSolution(i+1, right);
            for (TreeNode l : left_list) {
                for (TreeNode r: right_list) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
    
    
}