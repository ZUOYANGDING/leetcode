class Solution {
    public String getPermutation(int n, int k) {
        String res = "";
        String temp = "123456789";
        int fact = 1;
        for (int i=2; i<n; i++) {
            fact = fact*i;
        }
        int re = k-1;
        for (int i=n; i>=1; i--) {
            int p = re / fact;
            System.out.println(p+ " "+ re + " " +fact);
            res += temp.charAt(p);
            re = re % fact;
            temp = temp.substring(0, p) + temp.substring(p+1);
            if (i-1>0) {
                fact = fact / (i-1);   
            }
        }
        
        return res;
    }
}