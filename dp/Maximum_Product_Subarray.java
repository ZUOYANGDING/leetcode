// dp_max[i]: max product including element i;
// dp_min[i]: min product including element i;
// The reason to record the min product is if i+1 is negative, the min product will become the max
class Solution {
    public int maxProduct(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];
        dp_max[0] = nums[0];
        dp_min[0] = nums[0];
        int re = nums[0];
        for (int i=1; i<nums.length; i++) {
            dp_max[i] = Math.max(Math.max(dp_max[i-1]*nums[i], dp_min[i-1]*nums[i]),
                                nums[i]);
            dp_min[i] = Math.min(Math.min(dp_max[i-1]*nums[i], dp_min[i-1]*nums[i]),
                                nums[i]);
            re = Math.max(dp_max[i], re);
        }
        return re;
        
    }
}