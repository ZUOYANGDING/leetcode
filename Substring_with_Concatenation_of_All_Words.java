class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s==null || words.length==0) {
            return res;
        }
        HashMap<String, Integer> m = new HashMap<>();
        int step = words[0].length();
        int length = step * words.length;
        for (int i=0; i<words.length; i++) {
            if (m.containsKey(words[i])) {
                m.replace(words[i], m.get(words[i]), m.get(words[i])+1);
            } else {
                m.put(words[i], 1);
            }
        }
        
        for (int i=0; i<=(int)s.length() - length; i++) {
            String sub = s.substring(i, i+length);
            HashMap<String, Integer> m1 = new HashMap<>();
            int j=0;
            while(j < length) {
                String sub_word = sub.substring(j, j+step);
                if (m.containsKey(sub_word)) {
                    if (m1.containsKey(sub_word)) {
                        m1.replace(sub_word, m1.get(sub_word), m1.get(sub_word)+1);
                    } else {
                        m1.put(sub_word, 1);
                    }
                    if (m1.get(sub_word) > m.get(sub_word)) {
                        break;
                    }
                    j += step;
                } else {
                    break;
                }
            }
            if (j == length) {
                res.add(i);
            }
        }
        return res;
    }
}