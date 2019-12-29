class Solution {
    public int characterReplacement(String s, int k) {
        if (s==null || s.length()==0) {
            return 0;
        }
        int[] hash = new int[26];
        int start = 0, re = 0, max = 0;
        for (int i=0; i<s.length(); i++) {
            max = Math.max(max, ++hash[s.charAt(i)-'A']);
            while (i-start+1-max > k) {
                hash[s.charAt(start)-'A']--;
                start++;
            }
            re = Math.max(re, i-start+1);
        }
        return re;
    }
}