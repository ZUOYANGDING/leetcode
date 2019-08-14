class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int pre = 0;
        int index = 1;
        int count = 1;
        while (index < nums.length) {
            if (nums[index] == nums[pre] && count==0) {
                index++;
            } else {
                if (nums[index]==nums[pre]) {
                    count--;
                } else {
                    count = 1;
                }
                nums[++pre] = nums[index++];
            }
        }
        return pre+1;
    }
}