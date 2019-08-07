class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length<=1) {
            return true;
        }
        int index = 0;
        int pre = 0;
        int cur = 0;
        while (cur < nums.length-1) {
            pre = cur;
            for (; index<=pre; index++) {
                cur = Math.max(cur, index+nums[index]);
            }
            index = pre;
            if (pre == cur) {
                return false;
            }
        }
        return true;
    }
}