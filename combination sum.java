// This recursion structure can be applied to 
//Path Sum II，Subsets II，Permutations，Permutations II，Combinations and so on
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        } else if (target == 0) {
            re.add(new ArrayList<Integer>(sol));
        } else {
            for (int i=index; i<candidates.length; i++) {
                sol.add(candidates[i]);
                dfsSearch(candidates, i, target-candidates[i], re, sol);
                sol.remove(sol.size()-1);
            }
        }
    }
}