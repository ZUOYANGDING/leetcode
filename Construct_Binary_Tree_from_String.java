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
    public TreeNode str2tree(String s) {
        if (s==null || s.length()==0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root;
        int flag = 1;
        int first = 0;
        String temp1 = "";
        if (s.charAt(0)== '-') {
            flag = -1;
            first = 1;
        }
        while (first < s.length() && s.charAt(first)!='(') {
            temp1 += s.charAt(first++);
        }
        int val1 = Integer.parseInt(temp1);
        root = new TreeNode(val1 * flag);
        stack.push(root);
        for (int i=first; i<s.length(); i++) {
            if (s.charAt(i) == ')') {
                stack.pop();
            } else if (s.charAt(i) == '(') {
                int flag1 = 1;
                if (s.charAt(++i) == '-') {
                    i++;
                    flag1 = -1;
                }
                String temp = "";
                int k = i;
                while (k < s.length() && s.charAt(k)!='(' && s.charAt(k)!=')') {
                    temp += s.charAt(k);
                    k++;
                }
                int val = Integer.parseInt(temp);
                TreeNode node = new TreeNode(val * flag1);
                TreeNode sub_root = stack.peek();
                if (sub_root.left == null) {
                    sub_root.left = node;
                } else {
                    sub_root.right = node;
                }
                stack.push(node);
                i = k-1;
            }
        }
        return root;
    }
}