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
    List<TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        res.add(root);
        for (int i=0; i<to_delete.length; i++) {
            findRoot(to_delete[i]);
        }
        return res;
    }
    
    public void findRoot(int n) {
        for (int i=0; i<res.size(); i++) {
            if (n == res.get(i).val) {
                TreeNode t = res.get(i);
                if (t.left != null) {
                    res.add(t.left);
                }
                if (t.right !=null) {
                    res.add(t.right);
                }
                res.remove(i);
            } else {
                deleteNode(n, res.get(i));
            }
        }
    }
    
    public void deleteNode(int n, TreeNode root) {
        if (root.left!=null) {
            TreeNode temp= root.left;
            if (temp.val == n) {
                if (temp.left != null) {
                    res.add(temp.left);
                }
                if (temp.right != null) {
                    res.add(temp.right);
                }
                root.left = null;
                return;
            } else {
                deleteNode(n, temp);
            }
        }
        if (root.right!=null) {
            TreeNode temp= root.right;
            if (temp.val == n) {
                if (temp.left != null) {
                    res.add(temp.left);
                }
                if (temp.right != null) {
                    res.add(temp.right);
                }
                root.right = null;
                return;
            } else {
                deleteNode(n, temp);
            }
        } else {
            return;
        }
    }
}