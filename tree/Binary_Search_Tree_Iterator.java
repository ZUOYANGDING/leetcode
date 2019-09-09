/*
Same as the binary tree pre order traversal
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
class BSTIterator {
    private List<Integer> list;
    private int step;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while (root!=null || !s.isEmpty()) {
            while (root!=null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            list.add(root.val);
            root = root.right;
        }
        step = 0;
        
    }
    
    /** @return the next smallest number */
    public int next() {
        int res = list.get(step);
        step++;
        return res;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (step==list.size()) {
            return false;
        } else {
            return true;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */