class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int length = words.length;
        List<String> res = new ArrayList<>();
        if (words.length == 1) {
            String temp = "";
            temp += words[0];
            for (int i=temp.length(); i<maxWidth; i++) {
                temp += " ";
            }
            res.add(temp);
            return res;
        }
        int index = 0;
        int index1 = 1;
        Queue<String> queue = new LinkedList<>();
        boolean flag = false;
        while (index < length) {
            int space = 0;
            int rest = maxWidth - (words[index]).length();
            queue.add(words[index]);
            while (index1<length && (rest - (int) (words[index1]).length()) > space) {
                queue.add(words[index1]);
                rest -= (words[index1]).length();
                index1++;
                space++;
            }
            String s = "";
            if (index1 >= length) {
                flag = true;
            }
            while (!queue.isEmpty()) {
                s += queue.remove();
                if (space > 0 && !flag) {
                    int num_space = (rest%space==0) ? (rest/space) : (rest/space+1);
                    for (int i=0; i<num_space; i++) {
                        s += " ";
                    }
                    rest -= num_space;
                    space--;
                } else if (flag && rest>0){
                    s += " ";
                    rest--;
                }
            }
            for (int i=s.length(); i<maxWidth; i++) {
                s += " ";
            }
            res.add(s);
            index = index1;
            index1++;
        }
        return res;
    }
}