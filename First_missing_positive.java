/*
If nums are continues positive number, nums[i] = i + 1. Therefore, if 0<nums[i]<=nums.length,
it must can be put in position (nums[i] - 1). Appling swap to find the position that nums[i] belong
to. Then find the first of the rest postion with nums[i] != i+1, it is the answer.
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i=0; i<length; i++) {
            while (nums[i]>0 && nums[i]<=length && nums[i]!=nums[nums[i]-1]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i=0; i<length; i++) {
            if (nums[i]!=i+1) {
                return i+1;
            }
        }
        return length+1;
    }
}