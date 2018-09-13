class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> re = new ArrayList<>();
        if (len < 1 || nums[len-1] < 0) {
            return re;
        }
        for (int k=0; k<len; k++){
            if (nums[k] > 0){
                break;
            }
            if (k>0 && nums[k]==nums[k-1]){
                continue;
            }
            int i = k+1;
            int j = len - 1;
            int target = 0 - nums[k];
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[k]);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    re.add(temp);
                    while (i<j && nums[i] == nums[i+1]) {
                        i++;
                    }
                    while (i<j && nums[j] == nums[j-1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < target){
                    i++;
                } else {
                    j--;
                }
            }
        }
        return re;
    }
}