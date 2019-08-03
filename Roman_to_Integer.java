class Solution {
    public int romanToInt(String s) {
        if (s==null) {
            return 0;
        }
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X',             10);
        m.put('L',             50);
        m.put('C',             100);
        m.put('D',             500);
        m.put('M',             1000);
        if (s.length() == 1) {
            return m.get(s.charAt(0));
        }
        int index = 0;
        int res = 0;
        while (index < s.length()-1) {
            if (m.get(s.charAt(index)) < m.get(s.charAt(index+1))) {
                res = res + m.get(s.charAt(index+1)) - m.get(s.charAt(index));
                index += 2;
            } else {
                res += m.get(s.charAt(index)) ;
                index++;
            }
        }
        if (index < s.length()) {
            res += m.get(s.charAt(index));
        }
        return res;
    }
}