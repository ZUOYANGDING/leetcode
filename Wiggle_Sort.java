class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length==1) {
            return;
        }
        Arrays.sort(nums);
        if (nums.length==2) {
            return;
        }
        for (int i=1; i<nums.length-1; i+=2) {
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }n
    }
}