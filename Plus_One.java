class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> l = new ArrayList<>();
        int travel = 0;
        for (int i=digits.length-1; i>=0; i--) {
            int temp = 0;
            if (i==digits.length-1) {
                temp = (digits[i] + travel+1) % 10;
                travel = (digits[i] + travel+1) / 10;
            } else {
                temp = (digits[i] + travel) % 10;
                travel = (digits[i] + travel) / 10;
            }
            l.add(temp);
        }
        if (travel != 0) {
            l.add(travel);
        }
        int size = l.size();
        int index = size-1;
        int[] res = new int[size];
        for (int i=0; i<size; i++) {
            res[i] = l.get(index);
            index--;
        }
        return res;
    }
}