class Solution {
    public void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int red = 0;
        int cur = 0;
        int blue = nums.length-1;
        while (cur <= blue) {
            if (nums[cur] == 0) {
                int temp = nums[cur];
                nums[cur] = nums[red];
                nums[red] = temp;
                red++;
                cur++;
            } else if (nums[cur] == 2) {
                int temp = nums[cur];
                nums[cur] = nums[blue];
                nums[blue] = temp;
                blue--;
            } else {
                cur++;
            }
        }
        
    }
}