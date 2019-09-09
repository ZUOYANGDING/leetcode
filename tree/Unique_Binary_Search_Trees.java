/*
Apply Catalan number: Cn+1 = Sum(Cn-i * Ci), where i=0 to n. 
Or it can be represent as Choose n numbers from 2n numbers, then divided by (n+1):
(2n!)/(n!(n+1)!(n+1))

The Catalan number can be applied to 
1. Cn is the number of Dyck words[3] of length 2n. 
A Dyck word is a string consisting of n X's and n Y's 
such that no initial segment of the string has more Y's than X's. 
For example, the following are the Dyck words of length 6:
XXXYYY     XYXXYY     XYXYXY     XXYYXY     XXYXYY.
2. Cn is the number of different ways n + 1 factors can be completely parenthesized 
(or the number of ways of associating n applications of a binary operator). 
For n = 3, for example, we have the following five different parenthesizations of four factors:
((ab)c)d     (a(bc))d     (ab)(cd)     a((bc)d)     a(b(cd))
3. Successive applications of a binary operator 
can be represented in terms of a full binary tree. 
(A rooted binary tree is full if every vertex has either two children or no children.) 
It follows that Cn is the number of full binary trees with n + 1 leaves

More applications:
 https://en.wikipedia.org/wiki/Catalan_number
*/

class Solution {
    public int numTrees(int n) {
        int[] catalan = new int[n+1];
        catalan[0] = catalan[1] = 1;
        for (int i=2; i<n+1; i++) {
            for (int j=0; j<i; j++) {
                catalan[i] += catalan[i-j-1] * catalan[j];
            }
        }
        return catalan[n];
    }
}