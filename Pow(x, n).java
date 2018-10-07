//n/2 recusively, that reduce the time to logn
class Solution {
    public double myPow(double x, int n) {
        if (x==0 || n==1){
            return x;
        }
        if (n < 0){
            return 1 / pow(x, n);
        } else {
            return pow(x, n);
        }
    }
    
    public double pow(double x, int n){
        if (n==0){
            return 1.0;
        } else {
            double half = pow(x, n/2);
            if (n % 2 ==0){
                return (half*half);
            } else {
                return (x*half*half);
            }
        }
    }
}