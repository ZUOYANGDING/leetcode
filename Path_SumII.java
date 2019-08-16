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
    private List<List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        list = new ArrayList<>();
        List<Integer> new_list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        findSolution(root, sum, 0, new_list);
        return list;
    }
    
    public void findSolution (TreeNode root, int target, int n, List<Integer> new_list) {
        if (root.left==null && root.right==null) {
            if (root.val+n == target) {
                List<Integer> temp = new ArrayList<Integer>(new_list);
                temp.add(root.val);
                list.add(temp);
                return;
            } else {
                return;
            }
        }
        new_list.add(root.val);
        n += root.val;
        if (root.left != null) {
            findSolution(root.left, target, n, new_list);
        }
        if (root.right !=null) {
            findSolution(root.right, target, n, new_list);
        }
        new_list.remove(new_list.size()-1);
        return;
    }
}