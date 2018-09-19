//for permuataions, the first one will be accend order and the last one will be decend order.
//Therefore, check elements from end of the array, find the first one that less than previous
//swap this one with the first element larger than it from the end. Then reverse the order of
//rest array
class Solution {
    public void nextPermutation(int[] nums) {
        for (int i=nums.length-2; i>=0; i--){
            if (nums[i] < nums[i+1]){
                int index = nums.length-1;
                while (index>=0 && nums[index]<=nums[i]){
                    index--;
                }
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                // System.out.println(String.valueOf(i) + " " + String.valueOf(nums[i]) + " " + String.valueOf(nums[index]));
                reverse(i+1, nums.length, nums);
                return;
            }
        }
        reverse(0, nums.length, nums);
        return;
    }
    
    public void reverse(int head, int tail, int[] nums){
        for (int i=head; i<(tail+head)/2; i++){
            // System.out.println(tail);
            int temp = nums[i];
            nums[i] = nums[nums.length-i-1+head];
            nums[nums.length-i-1+head] = temp;
        }
        return;
    }
}