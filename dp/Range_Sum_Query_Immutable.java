// since sumRange need to be called several times. Therefore, create an array to record the sum of elements
// in nums from 0 to i. Then the sum[i, j] = sum[j] - sum[i]
class NumArray {
    
    private int[] num_array;
    private int[] sum_array;
        
    public NumArray(int[] nums) {
        this.num_array = nums;
        int length = nums.length;
        this.sum_array = new int[length+1];
        createSumArray(nums, length, sum_array);
    }
    
    public void createSumArray(int[] num_array, int length, int[] sum_array) {
        sum_array[0] = 0;
        for (int i=1; i<=length; i++) {
            sum_array[i] = sum_array[i-1] + num_array[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        if (i==j) {
            return num_array[i];
        } else {
            return sum_array[j+1] - sum_array[i];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */