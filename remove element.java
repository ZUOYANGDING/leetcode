class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length < 1){
            return nums.length;
        }
        int dup = 0;
        int len = 0;
        for (int i=0; i<nums.length; i++){
            while (i<nums.length-1 && nums[i]==val){
                dup++;
                i++;
            }
            if (nums[i]==val){
                break;
            }
            nums[i-dup] = nums[i];
            len++;
        }
        return len;
    }
}