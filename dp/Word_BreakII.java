// same recursive algorithm as word_break, but the mem HashMap also record the possible breaks 
// for a substring of s.
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> word_dict = new HashSet<String>(wordDict);
        Map<String, List<String>> mem = new HashMap<>();
        return help(s, word_dict, mem);
    }
    
    private List<String> help(String s, Set<String> word_dict, 
                              Map<String, List<String>> mem) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        List<String> re = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            String right = s.substring(i);
            if (word_dict.contains(right)) {
                List<String> left = help(s.substring(0, i), word_dict, mem);
                if (left.size() > 0) {
                    for (int j=0; j<left.size(); j++) {
                        re.add(left.get(j) + " " + right);
                    }
                } else if (i==0) {
                    re.add(right);
                }
            }
        }
        mem.put(s, re);
        return re;
    }
}