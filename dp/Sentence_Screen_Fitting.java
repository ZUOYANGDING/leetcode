class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int res = 0;
        int l = sentence.length;
        int[] count = new int[l];
        int index = 0;
        for (String word : sentence) {
            if (cols < word.length()) {
                return res;
            } else {
                count[index] = word.length();
                index++;
            }
        }
        int r = 0, c = 0;
        index = 0;
        while (r < rows) {
            if (index == l) {
                res++;
                index = 0;
            }
            if (c+count[index] > cols || c>=cols) {
                c = 0;
                r++;
            } else {
                c = c + count[index] + 1;
                index++;
            }
        }
        return res;
    }
} 