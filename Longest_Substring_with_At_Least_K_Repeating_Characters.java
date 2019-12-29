class Solution {
    public int longestSubstring(String s, int k) {
        if (s==null || s.length()==0 || k==0 || s.length()<k) {
            return 0;
        }
        int[] hash = new int[26];
        for (int i=0; i<s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        boolean all = true;
        for (int i=0; i<s.length(); i++) {
            if (hash[s.charAt(i) - 'a']>0 && hash[s.charAt(i) - 'a']<k) {
                all = false;
            }
        }
        if (all) {
            return s.length();
        }
        int start = 0, end = 0, re = 0;
        while (end<s.length()) {
            if (hash[s.charAt(end) - 'a'] < k) {
                re = Math.max(re, longestSubstring(s.substring(start, end), k));
                start = end+1;
            }
            end++;;
        }
        re = Math.max(re, longestSubstring(s.substring(start), k));
        return re;
    }
}