class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int diff = Math.abs(target - nums[0] - nums[1] - nums[2]);
        int re = nums[0] + nums[1] + nums[2];
        for (int k=0; k<len-1; k++){
            int i = k + 1;
            // System.out.println(nums[k]);
            int j = len - 1;
            while (i<j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (diff > Math.abs(target-sum)){
                    diff = Math.abs(target-sum);
                    re = sum;
                    // System.out.println(nums[i]);
                    // System.out.println(nums[j]);
                    // System.out.println(nums[k]);
                }
                if (sum < target){
                    // System.out.println(diff);
                    i++;
                } else {
                    // System.out.println(diff);
                    j--;
                }
            }
        }
        return re;
    }
}