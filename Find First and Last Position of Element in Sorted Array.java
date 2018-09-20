//Apply binary search. However, the problem is how to deal with nums[mid]==target situation.
//Need to search both left of the mid and right of mid
//Initial re[0]=nums.length, and re[1]=-1, which make sure search left index from right of the array
//and search right index from left of the array
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1){
            return new int[]{-1, -1};
        }
        int[] re = new int[2];
        re[0] = nums.length;
        re[1] = -1;
        int left = 0;
        int right = nums.length-1;
        findIndex(re, nums, left, right, target);
        if (re[0] > re[1]){
            return new int[] {-1, -1};
        }
        return re;
    }
    public void findIndex(int[] re, int[] nums, int left, int right, int target){
        int mid = left + (right-left)/2;
        if (left>right){
            return;
        }
        if (nums[mid]==target){
            if (mid<re[0]){
                re[0] = mid;
                findIndex(re, nums, left, mid-1, target);
            }
            if (mid>re[1]){
                re[1] = mid;
                findIndex(re, nums, mid+1, right, target);
            }
        } else if (nums[mid]>target){
            right = mid-1;
            mid = left + (right-left)/2;
            findIndex(re, nums, left, right, target);
        } else {
            left = mid + 1;
            mid = left + (right-left)/2;
            findIndex(re, nums, left, right, target);
        }
    }
}