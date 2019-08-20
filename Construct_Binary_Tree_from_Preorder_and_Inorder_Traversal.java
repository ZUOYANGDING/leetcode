/*
The first element of preorder is the root of the whole tree, then we can find it in inorder.
By this way, seperate these 2 arrays into 2 parts in every recursion:
pLeft(the most left element in preorder array that traversal can approach in this recursion), 
pRight(the the most right element in preorder array that traversal can approach in this recursion);
Same for iLeft and iRight.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return findSolution(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);  
    }
    
    public TreeNode findSolution(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft>pRight || iLeft>iRight) {
            return null;
        }
        int index = iLeft;
        while (index <= iRight) {
            if (preorder[pLeft] == inorder[index]) {
                break;
            }
            index++;
        }
        TreeNode node = new TreeNode(preorder[pLeft]);
        /* In inorder array elements are [left][mid][right]
        Therefore the number of element in left subtree
        is from iLeft to index-1 (total number of elements is (index-1-iLeft)); 
        The number of elementS right subtree is from index+1 to iRight (total number is iRight-index-1)
        
        In preorder array elements are [mid][left][right]
        Therefore, the number of element in left subtree is from pLeft+1 to (pLeft+1+index-1-iLeft), since we
        have already know how many elements are there from inorder array.
        The number of element in right subtree is from pLeft+index-iLeft+1 to (pLeft+index-iLeft+1+iRight-index-1
        =pLeft-iLeft+iRight = pRight)
        */
        node.left = findSolution(preorder, pLeft+1, pLeft+index-iLeft, inorder, iLeft, index-1);
        node.right = findSolution(preorder, pLeft+index-iLeft+1, pRight, inorder, index+1, iRight);
        return node;
    }
}