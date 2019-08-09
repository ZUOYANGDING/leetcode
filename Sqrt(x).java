/*
Newton approach way to find f(x) = x^2 - n = 0
xi+1=xi - (xi2 - n) / (2xi) = xi - xi / 2 + n / (2xi) = xi / 2 + n / 2xi = (xi + n/xi) / 2
*/

class Solution {
    public int mySqrt(int x) {
       if (x == 0) return 0;
        double res = 1, pre = 0;
        while (Math.abs(res - pre) > 1e-6) {
            pre = res;
            res = (res + x / res) / 2;
        }
        return (int) res;
    }
}
