/*
When serialize the tree, store the string as node_val, number of node children. And seperate them by ",". 
When deserialize the string, apply the queue to store the string
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return String.join(",", res);
        }
        serializeHelper(root, res);
        return String.join(",", res);
    }
    
    public void serializeHelper(Node root, List<String> res) {
        if (root == null) {
            return;
        }
        res.add(String.valueOf(root.val));
        res.add(String.valueOf(root.children.size()));
        for (Node child: root.children) {
            serializeHelper(child, res);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data==null || data.length()==0) {
            return null;
        }
        String[] s = data.split(",");
        Queue<String> q = new LinkedList<String>(Arrays.asList(s));
        return deserializeHelp(q);
        
    }
    
    public Node deserializeHelp(Queue<String> q) {
        Node new_node = new Node();
        new_node.val = Integer.parseInt(q.poll());
        int size = Integer.parseInt(q.poll());
        new_node.children = new ArrayList<Node>(size);
        for (int i=0; i<size; i++) {
            new_node.children.add(deserializeHelp(q));
        }
        return new_node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));