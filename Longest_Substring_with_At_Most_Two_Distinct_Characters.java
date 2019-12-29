class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s==null) {
            return 0;
        }
        int left = 0;
        int re = 0;
        Map<Character, Integer> dic = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (dic.containsKey(c)) {
                dic.put(c, dic.get(c)+1);
            } else {
                dic.put(c, 1);
            }
            while (dic.size() > 2) {
                char c1 = s.charAt(left);
                if (dic.get(c1) > 1) {
                    dic.put(c1, dic.get(c1)-1);
                } else {
                    dic.remove(c1);
                }
                left++;
            }
            re = Math.max(i-left+1, re);
        }
        return re;       
    }
}