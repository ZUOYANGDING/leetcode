//Same consideration as Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal 

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       return findSolution(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1); 
    }
    
    public TreeNode findSolution(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight) {
        if (iLeft>iRight || pLeft>pRight) {
            return null;
        }
        int index = iLeft;
        while (index <= iRight) {
            if (inorder[index] == postorder[pRight]) {
                break;
            }
            index++;
        }
        TreeNode node = new TreeNode(postorder[pRight]);
        node.left = findSolution(inorder, iLeft, index-1, postorder, pLeft, pLeft+index-1-iLeft);
        node.right = findSolution(inorder, index+1, iRight, postorder, pRight-iRight+index, pRight-1);
        return node;
    }
}