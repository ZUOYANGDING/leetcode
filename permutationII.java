class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        ArrayList<Integer> sol = new ArrayList<>();
        int len = nums.length;
        int[] used = new int[len];
        Arrays.sort(nums);
        findSolution(nums, used, re, sol);
        return re;
    }
    
    public void findSolution(int[] nums, int[] used, List<List<Integer>> re, ArrayList<Integer> sol){
        if (nums.length == sol.size()){
            re.add(new ArrayList<Integer>(sol));
            return;
        } else{
            for (int i=0; i<nums.length; i++){
                //check if the number at position i already in list of not (same as the permutation I)
                if (used[i]==1){
                    continue;
                }
                //if this number is same as previous one, and previous number has not been used
                //which means this number has already been put as first number, this time is just switched postion
                //jump this duplicate solution
                if (i>0 && nums[i]==nums[i-1] && used[i-1]==0){
                    continue;
                }
                sol.add(nums[i]);
                used[i] = 1;
                findSolution(nums, used, re, sol);
                used[i] = 0;
                sol.remove(sol.size()-1);
            }
        }
    }
}