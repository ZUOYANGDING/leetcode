/*
basic idea is the same as Serialize and Deserialize N-ary Tree. Since it is a binary tree,
there is no need to store the number of children of each node. Instead of it, if left or right
child is null, use "#" to mark it.

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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root==null) {
            return String.join(",", res);
        }
        serializerHelper(root, res);
        for (String s : res) {
            System.out.println(s);
        }
        return String.join(",", res);
    }
    
    public void serializerHelper(TreeNode root, List<String> res) {
        if (root == null) {
            res.add("#");
            return;
        }
        res.add(String.valueOf(root.val));
        serializerHelper(root.left, res);
        serializerHelper(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null || data.length()==0) {
            return null;
        }
        String[] s = data.split(",");
        Queue<String> q = new LinkedList<String>(Arrays.asList(s));
        return deserializerHelper(q);
    }
    
    public TreeNode deserializerHelper(Queue<String> q) {
        String s = q.poll();
        if (s.equals("#")) {
            return null;
        }
        TreeNode new_node = new TreeNode(Integer.parseInt(s));
        new_node.left = deserializerHelper(q);
        new_node.right = deserializerHelper(q);
        return new_node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));