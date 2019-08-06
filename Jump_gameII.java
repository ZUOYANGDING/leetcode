class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }
        int pre = 0;
        int cur = 0;
        int jump = 0;
        int index = 0;
        while (cur < length-1) {
            pre = cur;
            while (index <= pre) {
                cur = Math.max(cur, index+nums[index]);
                index++;
                System.out.println(cur + " " + index + " " + pre);
            }
            index = pre;
            jump++;
        }
        return jump;
    }
}