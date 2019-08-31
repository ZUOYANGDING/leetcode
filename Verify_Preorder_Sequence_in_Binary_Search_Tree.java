/*
In preorder traversal the outcome array should be [MID][LEFT][RIGHT], therefore, we can apply a stack
, then push the first number in (the root of the whole BST). Keep push the element if the element is
less then the top element of stack (which means push the left subtree). If the element is larger then
the top element of the stack, which means we approach the right subtree. Since right>mid>left in BST,
we start to pop from the stack (only pop the element, do not go to next element in array). 
During the process we maintain a variable MIN, which mark the value of the left
node in the current subtree (or the root of current tree). 
Keep doing the pop processing until the top the stack is larger than the current element in array, which
means we meet the root of the previous BST (the current element in array is the right node of the left subtree
of the previous tree). Then we push the current element into the stack, now the top of the stack is the right most
node of the left subtree of the upper level BST. Then go to the next element in the array, which should be the root 
of the right subtree of the upper level BST, which is larger then the top of the stack, pop the stack and update the
value MIN. Then the top of stack should be the root of the upper level BST, shich still less than the root of right subtree,
pop it and update the value MIN. Now the stack might be empty (if we poped root of whole tree), 
push the the current element in the stack, then we entering the right subtree of the whole tree.
For example:
                                5
                        2               7
                    1       3       6       8
1.  stack: 5, 2, 1          apprach 3
    min = min_value

2.  stack 5, 2              approach 3
    min = 2

3.  stack: 5                approach 3
    min = 2
            
4.  stack: 5, 3             approach 3
    min = 2

5.  stack: 5                approach 7
    min = 3

6.  stack: null             approach 7
    min = 5

7.  stack: 7                approach 6
    min = 5

If the array is not preorder, the node value will be larger than the MIN, which means right > mid(or left).


To use the constant space, we cannot use stack. Therefore, use the preorder array to imitate the stack,
which means store the MIN into the check part of the array.
for the previous example:
when approach 3:
index           MIN                     array                           node 
2               2                       5 2 1 3 7 6 8                   3
1               2                       5 2 1 3 7 6 8                   3
0               2                       5 2 1 3 7 6 8                   3
1               2                       5 3 1 3 7 6 8                   7
0               3                       5 3 1 3 7 6 8                   7
-1              5                       5 3 1 3 7 6 8                   7
0               5                       7 3 1 3 7 6 8                   6
*/ 
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE, index = -1;
        for (Integer node : preorder) {
            if (node < min) {
                return false;
            }
            while (index>=0 && node>preorder[index]) {
                min = preorder[index--];
            }
            preorder[++index] = node;
        }
        return true;
    }
}