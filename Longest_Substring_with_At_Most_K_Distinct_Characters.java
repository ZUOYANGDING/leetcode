class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length()==0 || k==0) {
            return 0;
        }
        Map<Character, Integer> dict = new HashMap<>();
        int re = 0;
        int left = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (dict.containsKey(c)) {
                dict.put(c, dict.get(c)+1);
            } else {
                dict.put(c, 1);
            }
            while (dict.size() > k) {
                char c1 = s.charAt(left);
                if (dict.get(c1) > 1) {
                    dict.put(c1, dict.get(c1)-1);
                } else {
                    dict.remove(c1);
                }
                left++;
            }
            re = Math.max(re, i-left+1);
        }
        return re;
    }
}