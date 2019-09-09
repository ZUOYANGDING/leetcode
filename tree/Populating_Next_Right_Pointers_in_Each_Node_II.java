/*
Use 2 pointer, one marks the start node of this level, another one marks the current visitng node.
Then create a dummy node whose next is point to the first child of this level, then create a pointer
point to it, then change its next pointer to link each node in this level.

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node start = root;
        Node cur;
        // can create the dummy for each level, to instead create the preRigtht
        // but the space using is not constant;
        Node dummy = new Node();
        while (start != null) {
            cur = start;
            while (cur!=null && cur.left==null && cur.right==null) {
                cur = cur.next;
            }
            if (cur == null) {
                break;
            }
            start = (cur.left!=null) ? cur.left : cur.right;
            dummy.next = start;
            Node preRight = dummy;
            while (cur != null) {
                if (cur.left!=null && cur.right!=null) {
                    preRight.next = cur.left;
                    cur.left.next = cur.right;
                    preRight = cur.right;
                } else if (cur.left==null && cur.right!=null) {
                    preRight.next = cur.right;
                    preRight = cur.right;
                } else if (cur.left!=null && cur.right==null) {
                    preRight.next = cur.left;
                    preRight = cur.left;
                }
                cur = cur.next;
            }
        }
        return root;
    }
}