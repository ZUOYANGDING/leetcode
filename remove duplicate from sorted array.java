class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1){
            return nums.length;
        }
        int dup = 0;
        int len = 0;
        for (int i=0; i<nums.length; i++){
            int temp = nums[i];
            while (i+1<nums.length && nums[i] == nums[i+1]){
                i++;
                dup++;
            }
            nums[i-dup] = temp;
            len++;
        }
        return len;
    }
}