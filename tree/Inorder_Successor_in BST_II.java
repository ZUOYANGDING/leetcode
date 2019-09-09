/*
By go through the examples, if the inorder larger node exists, it can be found in two cases.
1. At the right child's most left child.
2. At the ancient node
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    public Node inorderSuccessor(Node x) {
        Node res = null;
        if (x.right != null) {
            x = x.right;
            while (x.left != null) {
                x = x.left;
            }
            res = x;
        } else {
            res = x.parent;
            while (res!=null && res.val < x.val) {
                res = res.parent;
            }
        }
        return res;
    }
}

/* The following is the way to approach the answer without visit the val of the node. Since the target
node is  at the right child's most left child or at the ancient node, check the right child condition
first. If there is no right child, check the ancient node. Since it is a BST (left<parent<right), find the 
parent node whose left node's child (or left child) is the start node, the parent node is the target node
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    public Node inorderSuccessor(Node x) {
        Node res = null;
        if (x.right != null) {
           x = x.right;
           while (x.left != null) {
               x = x.left;
           }
           res = x;
        } else {
           res = x.parent;
           while (res!=null && res.left != x) {
               x = res;
               res = res.parent;
           }
        }
        return res; 
    }
}