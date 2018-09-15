//similar way, but fix head and tail.
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> re = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0) {
            return re;
        } 
        for (int i=0; i<nums.length; i++){
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int t1 = target-nums[i];
            for (int j=nums.length-1; j>i; j--){
                if (j<nums.length-1 && nums[j]==nums[j+1]) {
                    continue;
                }
                int t2 = t1 - nums[j];
                int index_1 = i+1;
                int index_2 = j-1;
                while (index_1 < index_2){
                    if (nums[index_1]+nums[index_2] == t2){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[index_1]);
                        temp.add(nums[index_2]);
                        re.add(temp);
                        while (index_1<index_2 && nums[index_1] == nums[index_1+1]){
                            index_1++;
                        }
                        while (index_1<index_2 && nums[index_2] == nums[index_2-1]){
                            index_2--;
                        }
                        index_1++;
                        index_2--;
                    } else if (nums[index_1]+nums[index_2] < t2){
                        index_1++;
                    } else {
                        index_2--;
                    }
                }
            }
        }
        return re;
    }
}