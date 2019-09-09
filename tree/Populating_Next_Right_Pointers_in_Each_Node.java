/*
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
        List<Node> parent = new ArrayList<>();
        parent.add(root);
        while (!parent.isEmpty()) {
            List<Node> children = new ArrayList<>();
            for (int i=0; i<parent.size(); i++) {
                Node temp = parent.get(i);
                if (temp != null) {
                    if (i+1 < parent.size()) {
                        temp.next = parent.get(i+1);
                    }
                    children.add(temp.left);
                    children.add(temp.right);
                }
            }
            parent = children;
        }
        return root;
    }
}