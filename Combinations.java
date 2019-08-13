class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> new_res = new ArrayList<>();
        findSolution(n, k, 1, new_res);
        return res;
    }
    
    public void findSolution(int n, int k, int level, List<Integer> new_res) {
        if (new_res.size() == k) {
            List<Integer> temp = new ArrayList<Integer>(new_res);
            res.add(temp);
            return;
        }
        for (int i=level; i<=n; i++) {
            new_res.add(i);
            findSolution(n, k, i+1, new_res);
            new_res.remove(new_res.size()-1);
        }
    }
}