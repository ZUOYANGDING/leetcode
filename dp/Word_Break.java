// Apply the memory recursion. Scan the whole string, seperate the whole string into 2 parts [0, i) and
// [i+1, s.length()]. If the second part is in dictionary, recursive on frist part. To eliminate the
// duplicate computing, use a HashMap to recored the substring that has already been checked.

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> word_dict = new HashSet<String>(wordDict);
        Map<String, Boolean> mem = new HashMap<>();
        return help(s, word_dict, mem);
    }
    
    private boolean help(String s, Set<String> word_dict, Map<String, Boolean> mem) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        if (word_dict.contains(s)) {
            mem.put(s, true);
            return true;
        }
        
        for (int i=1; i<s.length(); i++) {
            if (word_dict.contains(s.substring(i)) && 
                help(s.substring(0, i), word_dict, mem)) {
                mem.put(s, true);
                return true;
            }
        }
        mem.put(s, false);
        return false;
    }
}

// Similar idea by applying DP. Scan the whole string; For each substring[0, i], seperate it by [0, j]
// and [j+1, i]. If [0, j] in DP is true, means left part can be sperated and find in dictionay, then only
// need to check the right part. Therefore, the answer is the last element in DP array.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> word_dict = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<i; j++) {
                if (dp[j] && word_dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
}