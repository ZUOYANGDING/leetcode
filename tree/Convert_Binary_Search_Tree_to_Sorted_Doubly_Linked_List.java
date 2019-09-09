/*
Apply inorder traversal, use pre to mark the previous node visited in each recursion
*/



/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node pre;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node head = new Node(-1, null, null);
        pre = head;
        findSolution(root, head);
        pre.right = head.right;
        head.right.left = pre;
        return head.right;
    }
    
    public void findSolution(Node root, Node head) {
        if (root == null) {
            return;
        }
        findSolution(root.left, head);
        if (head.right == null) {
            head.right = root;
            pre = root;
        } else if (head.right != null) {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        findSolution(root.right, head);
    }
}