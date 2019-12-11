// DFS (brute force), time complexity is O(2^n), 
class Solution {
    private int re;
    
    public int minSwap(int[] A, int[] B) {
        re = Integer.MAX_VALUE;
        dfs(A, B, 1, 0);
        return re;
    }
    
    public void dfs(int[] A, int[] B, int i, int count) {
        if (count >= re) {
            return;
        }
        if (i >= A.length) {
            re = Math.min(count, re);
            return;
        }
        
        if (A[i] > A[i-1] && B[i] > B[i-1]) {
            dfs(A, B, i+1, count);
        } 
        if (A[i] > B[i-1] && B[i] > A[i-1]) {
            swap(A, B, i);
            dfs(A, B, i+1, count+1);
            swap(A, B, i);
        }
    }
    
    public void swap(int[] A, int[] B, int i) {
        int temp = A[i];
        A[i] = B[i];
        B[i] = temp;
    }
    
}

// DP, time complexity is O(n)
/* When consider index i and i-1, there are 4 conditions:
    1. no swap at i and i-1
    2. swap at i and i-1
    3. swap at i-1 but keep at i
    4. keep at i-1 but swap at i
   use 2 arrays keep and swap to record at index i how many swaps we need. keep[i] means no swap at i,
   swap[i] means swap elements at i.
*/

class Solution {
    public int minSwap(int[] A, int[] B) {
        int[] keep = new int[A.length];
        int[] swap = new int[B.length];
        for (int i=0; i<A.length; i++) {
            keep[i] = Integer.MAX_VALUE;
            swap[i] = Integer.MAX_VALUE;
        }
        
        keep[0] = 0;
        swap[0] = 1;
        
        for (int i=1; i<A.length; i++) {
            // already in sticky increasing, find the reason cause this condition
            if (A[i] > A[i-1] && B[i] > B[i-1]) {
                // no swap at i and i-1, it can be transformed from:
                // 1. keep at i-1 and i-2
                // 2. keep at i-1 but swap at i-2
                keep[i] = keep[i-1];
                // swap at i and i-1, it can be transformed from:
                // 1. swap at i-1 and i-2
                // 2. swap at i-1 but keep at i-2
                swap[i] = swap[i-1]+1;
            }
            // already in sticky increasing (the reason to use Math.min for compare)
            // or can be sticky increasing by swap, find the reason cause this condition
            if (A[i] > B[i-1] && B[i] > A[i-1]) {
                // swap at i-1 but keep at i, it can be transformed from:
                // 1. swap at i-1 and i-2
                // 2. swap at i-1 but keep at i-2
                keep[i] = Math.min(keep[i], swap[i-1]);
                // swap at i-1 but keep at i, it can be transformed from:
                // 1. keep at i-1 and i-2
                // 2. keep at i-1 but swap at i-2
                swap[i] = Math.min(keep[i-1]+1, swap[i]);
            }
        }
        return Math.min(keep[A.length-1], swap[A.length-1]);
    }
}
