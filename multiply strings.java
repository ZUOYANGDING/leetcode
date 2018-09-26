//apply the way that calcuate the multiplicaiton. First of all calculate the solution for every position with
//carry. Then solve the carry
// EX: 123 * 456
//                  1   2   3
//                  4   5   6
//      ____________________________
//                  6   12  18
//              5   10  15
//         4    8   12
//      _____________________________
//         4    13  28  27    18
                     
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length()==1){
            if (num1.charAt(0)=='0'){
                return "0";
            }
        }
        if (num2.length()==1){
            if (num2.charAt(0)=='0'){
                return "0";
            }
        }
        
        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 + len2 - 2;
        int[] temp = new int[len2+len1];
        int carry = 0;
        //store sol without carry
        for (int i=0; i<num1.length(); i++){
            for (int j=0; j<num2.length(); j++){
                temp[len-i-j] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }
        //deal with carry on every position
        for (int i=0; i<len1+len2; i++){
            temp[i] += carry;
            carry = temp[i] / 10;
            temp[i] %= 10;
        }
        //delete all zeros;
        len = len1+len2-1;
        while (temp[len]==0 && len>=0){
            len--;
        }
        if (len < 0){
            return "0";
        }
        //build the answer
        String re = "";
        for (int i=len; i>=0; i--){
            re += temp[i];
        }
        return re;
    }
}