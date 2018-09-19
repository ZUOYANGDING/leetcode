class Solution {
    public int divide(int dividend, int divisor) {
        int signal = 1;
        if ((dividend>0) ^ (divisor>0)){
            signal = -1;
        }
        if (dividend==Integer.MAX_VALUE && divisor==-1){
            return Integer.MIN_VALUE;
        }
        if (dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        if (dividend==Integer.MIN_VALUE && divisor==1){
            return Integer.MIN_VALUE;
        }
        long new_dd = (long) Math.abs((long)dividend);
        long new_dr = (long) Math.abs((long)divisor);
        if (new_dr==1 && signal==1){
            return signal==1 ? Math.toIntExact(new_dd) : -Math.toIntExact(new_dd);
        }
        long re = 0;
        while (new_dd >= new_dr){
            long count_1 = new_dr;
            long count_2 = 1;
            while ((count_1<<1) < new_dd){
                count_1 <<= 1;
                count_2 <<= 1;
            }
            re += count_2;
            new_dd -= count_1;
        }
        return signal==1 ? Math.toIntExact(re) : -Math.toIntExact(re);
    }
}