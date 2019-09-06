/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Treat every node as the root of the tree, then check if the tree is BST or not, update the largest
// size of the BST. This solution cost time O(N^2)
class Solution {
    private int size;
    public int largestBSTSubtree(TreeNode root) {
        size = 0;
        if (root == null) {
            return size;
        }
           
        dfs(root);
        return size;
    }
    
    public void dfs(TreeNode root) {
        if (root==null) {
            return;
        }
        int count = findSolution(root, Long.MIN_VALUE, Long.MAX_VALUE);
        if (count!=-1) {
            size = Math.max(size, count);
        }
        dfs(root.left);
        dfs(root.right);
    }
    
    public int findSolution(TreeNode root, long min, long max) {
        if (root == null) {
            return 0;
        }
        if (root.val<=min || root.val>=max) {
            return -1;
        }
        int left = findSolution(root.left, min, root.val);
        if (left == -1) {
            return -1;
        }
        int right = findSolution(root.right, root.val, max);
        if (right == -1) {
            return -1;
        }
        return left+right+1;
    }
    
}


// Another way to solve this problem is check the whole tree from bottom up to root. For a node
// as a root, it should be larger than the max of left subtree, and smaller then the min of right
// subtree.
class Solution {
    private class Ret {
        boolean isBST;
        int maxSize;
        int min;
        int max;
        public Ret (boolean isBST, int maxSize, int min, int max) {
            this.isBST = isBST;
            this.maxSize = maxSize;
            this.min = min;
            this.max =max;
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        return findSolution(root).maxSize;
    }
    
    public Ret findSolution(TreeNode root) {
        if (root == null) {
            // there set the min as MAX_VALUE and max as MIN_VALUE is the way to make the leaf node
            // returned as (true, 1, leafnode.val, leafnode.val)
            return new Ret(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Ret left = findSolution(root.left);
        Ret right = findSolution(root.right);
        if (!left.isBST || !right.isBST || root.val<=left.max || root.val>=right.min) {
            // if this node cannot be regarded as the root of a BST, return this node as a null to the upper level
            return new Ret(false, Math.max(left.maxSize, right.maxSize), Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        return new Ret(true, left.maxSize+right.maxSize+1, Math.min(root.val, left.min), Math.max(root.val, right.max));
    }
}