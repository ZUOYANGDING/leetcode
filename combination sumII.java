class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> re = new ArrayList<>();
        ArrayList<Integer> sol = new ArrayList<>();
        int index = 0;
        Arrays.sort(candidates);
        dfsSearch(candidates, index, target, re, sol);
        return re;
    }
    public void dfsSearch(int[] candidates, int index, int target, List<List<Integer>> re, ArrayList<Integer> sol){
        if (target < 0){
            return;
        } else if (target == 0){
            re.add(new ArrayList<Integer> (sol));
        } else {
            for (int i=index; i<candidates.length; i++){
                if (i>index && candidates[i]==candidates[i-1]){
                    continue;
                }
                sol.add(candidates[i]);
                dfsSearch(candidates, i+1, target-candidates[i], re, sol);
                sol.remove(sol.size()-1);
            }
        }
    }
}