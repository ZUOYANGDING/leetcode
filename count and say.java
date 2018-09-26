class Solution {
    public String countAndSay(int n) {
        if (n < 1){
            return "";
        }
        if (n==1){
            return "1";
        }
        String s = "1";
        String re = "";
        while (n > 1){
            String temp = "";
            for (int i=0; i<s.length(); i++){
                int count = 1;
                while (i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                    count++;
                    i++;
                }
                temp += String.valueOf(count);
                temp += s.charAt(i);
            }
            s = temp;
            System.out.println(temp);
            n--;
        }
        re = s;
        return re;
    }
}