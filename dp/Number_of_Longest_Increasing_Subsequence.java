// Recursive with record
class Solution {
    private int[] length;
    private int[] count;
    
    public int findNumberOfLIS(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        length = new int[nums.length];
        count = new int[nums.length];
        
        int max_length = 1;
        for (int i=0; i<nums.length; i++) {
            max_length = Math.max(max_length, findMaxLength(i, nums));
        }
        System.out.println(Arrays.toString(length));
        int re = 0;
        for (int i=0; i<nums.length; i++) {
            if (length[i] == max_length) {
                re += countNumber(i, nums);
            }
        }
        return re;
    }
    
    // find the max length at index i
    public int findMaxLength(int n, int[] nums) {
        if (length[n] > 0) {
            return length[n];
        }
        if (n==0) {
            length[n] = 1;
            return 1;
        }
        int max_length = 1;
        for (int i=0; i<n; i++) {
            if (nums[n] > nums[i]) {
                max_length = Math.max(max_length, findMaxLength(i, nums)+1);
            }
        }
        length[n] = max_length;
        return length[n];
    }
    
    // find the number of increasing subsequences at index i
    public int countNumber(int n, int[] nums) {
        if (n==0) {
            return 1;
        }
        if (count[n] > 0) {
            return count[n];
        }
        int total = 0;
        for (int i=0; i<n; i++) {
            // find the total number of increasing subsequences at index i
            // the longest increasing subsequence ended with nums[n], 
            // and the longest increasing subsequence ended with nums[i] is 1 shorter than length(nums[n])
            // which means add the element nums[n], the number of subsequences is the same.
            if (nums[n] > nums[i] && length[i]==length[n]-1) {
                total += countNumber(i, nums);
            }
        }
        if (total==0) {
            total = 1;
        }
        count[n] = total;
        return count[n];
    }
}