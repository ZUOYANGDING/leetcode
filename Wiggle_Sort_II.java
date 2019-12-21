/*
Sort the array in ascending order, then sperate the array into 2 parts. 
Take the last from first half, and the last from the second half. Rebuild the array.
*/
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums==null || nums.length<2) {
            return;
        }
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int mid = (nums.length+1)/2;
        int end = nums.length;
        boolean b = true;
        for (int i=0; i<nums.length; i++) {
            if (b) {
                nums[i] = temp[--mid];
                b = false;
            } else {
                nums[i] = temp[--end];
                b = true;
            }
        }
    }
}