class Solution {
    public int nthUglyNumber(int n) {
        int[] re = new int[n];
        re[0] = 1;
        int i2=0, i3=0, i5=0;
        int count = 1;
        while (count<n) {
            int i2_re = re[i2] * 2;
            int i3_re = re[i3] * 3;
            int i5_re = re[i5] * 5;
            int min = Math.min(Math.min(i2_re, i3_re), i5_re);
            if (min == i2_re) {
                i2++;
            }
            if (min == i3_re) {
                i3++;
            }
            if (min == i5_re) {
                i5++;
            }
            re[count] = min;
            count++;
        }
        
        return re[n-1];
    }
}