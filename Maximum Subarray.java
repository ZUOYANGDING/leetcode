//Apply dp algrithom. max_window to record the max sum find until right now. current_max_window is a way
//to choose between expend the right side of the sliding window or jump the left side of the window to
//current index. It means suppose solved [1...i-1], comapre the [1...i] and [i], then compare the
//result to the solved max subarray in [1...i-1]. For this problem, just need to return the max sum,
//but also can return the index to show the subarray with the max sum
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int max_window = nums[0];
        int current_max_window = nums[0];
        for (int i=1; i<nums.length; i++){
            //compare the max window between [1...i] and [i]
            current_max_window = Math.max(current_max_window+nums[i], nums[i]);
            //comapre the max window between [1...i-1] and max([1..i], [i])
            max_window = Math.max(max_window, current_max_window);
        }
        return max_window;
    }
}