class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();
        if (nums.length < 1){
            return re;
        }
        Arrays.sort(nums);
        getPermutation(nums, re, p);
        return re;
    }
    public void getPermutation(int[] nums, List<List<Integer>> re, ArrayList<Integer> p){
        if (p.size() == nums.length){
            re.add(new ArrayList<Integer>(p));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (p.contains(nums[i])){
                continue;
            }
            p.add(nums[i]);
            getPermutation(nums, re, p);
            p.remove(p.size()-1);   
        }
    }
}