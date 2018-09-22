class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len < 1 || target<nums[0]){
            return 0;
        }
        int index = 0;
        while (index<len){
            if (nums[index]==target){
                return index;
            }
            if (index>0 && nums[index-1]<target && nums[index]>target){
                return index;
            }
            index++;
        }
        return len;
    }
}class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len < 1 || target<nums[0]){
            return 0;
        }
        int index = 0;
        while (index<len){
            if (nums[index]==target){
                return index;
            }
            if (index>0 && nums[index-1]<target && nums[index]>target){
                return index;
            }
            index++;
        }
        return len;
    }
}