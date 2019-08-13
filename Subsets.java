class Solution {
    private List<List<Integer>> res;
    private int[] temp_nums;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        temp_nums = nums;
        if (nums==null || nums.length==0) {
            return res;
        }
        List<Integer> new_res = new ArrayList<>();
        for (int i=1; i<=nums.length; i++) {
            findSolution(nums.length, i, 0, new_res);
        }
        res.add(new_res);
        return res;
    }
    
    public void findSolution(int n, int k, int level, List<Integer> new_res) {
        if (new_res.size() == k) {
            List<Integer> temp = new ArrayList<Integer>(new_res);
            res.add(temp);
            return;
        }
        for (int i=level; i<n; i++) {
            new_res.add(temp_nums[i]);
            findSolution(n, k, i+1, new_res);
            new_res.remove(new_res.size()-1);
        }
    }
}