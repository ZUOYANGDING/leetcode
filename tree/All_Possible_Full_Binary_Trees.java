/*
If N is a even number, it is impossible to create the full binary tree.
Therefore, we need to consider how many possible combinations of 2 odd numbers p and q that p+q=N-1.
Therefore, find the p from 1 to N-1, and q from N-2 to 1 (0 is even, omit it) recursively.
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
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (N % 2 == 0) {
            return res;
        }
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int i=1; i<=N-1; i+=2) {
            List<TreeNode> lefts = allPossibleFBT(i);
            List<TreeNode> rights = allPossibleFBT(N-1-i);
            for (TreeNode leftNode : lefts) {
                for (TreeNode rightNode: rights) {
                    TreeNode temp = new TreeNode(0);
                    temp.left = leftNode;
                    temp.right = rightNode;
                    res.add(temp);
                }
            }
        }
        return res;
    }
}