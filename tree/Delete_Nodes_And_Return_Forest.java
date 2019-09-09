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

/*
The previous way is too slow O(N^2). Consider as follow: we only add root into the return list,
Therefore, a node will be add into the return list when the node is the root or, its parent has
been deleted. Go through the whole BT, if the node contains value in to_delete, delete it and 
set the flag as true (means its children will be add into return list if children will not be deleted).

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
    List<TreeNode> res;
    Set<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        findSolution(root, true);
        return res;
    }
    
    public TreeNode findSolution(TreeNode root, Boolean isRoot) {
        if (root == null) {
            return null;
        }
        boolean isDelete = set.contains(root.val);
        if (isRoot && !isDelete) {
            res.add(root);
        }
        root.left = findSolution(root.left, isDelete);
        root.right = findSolution(root.right, isDelete);
        if (isDelete) {
            return null;
        } else {
            return root;
        }
    }
}