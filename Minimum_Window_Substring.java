/*
Apply slide window, use negative number in hashmap to mark the character belong to t, 
but number of character appears in window is more than number of that character appears in t
*/
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.replace(t.charAt(i), map.get(t.charAt(i)), map.get(t.charAt(i)) + 1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }
        String res = "";
        int min = Integer.MAX_VALUE;
        int left = 0;
        int index = 0;
        int length = 0;
        while (index < s.length()) {
            if (map.get(s.charAt(index))!=null) {
                if (map.get(s.charAt(index))>0) {
                    length++;
                }
                map.replace(s.charAt(index), map.get(s.charAt(index)), map.get(s.charAt(index)) - 1);
            }
            while (length == t.length()) {
                if (min > index-left+1) {
                    min = index-left+1;
                    System.out.println(index + " " + left);
                    res = s.substring(left, index+1);
                }
                if (map.containsKey(s.charAt(left))) {
                    map.replace(s.charAt(left), map.get(s.charAt(left)), map.get(s.charAt(left)) + 1);
                    if (map.get(s.charAt(left)) > 0) {
                        length--;
                    }
                }
                left++;
            }
            index++;
        }
        return res;
    }
}