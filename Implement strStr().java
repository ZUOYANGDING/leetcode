class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        if (needle.length() > haystack.length()){
            return -1;
        }
        for (int i=0; i<=haystack.length()-needle.length(); i++){
            int index = 0;
            int temp = i;
            while (temp<haystack.length() && index<needle.length() && haystack.charAt(temp)==needle.charAt(index)){
                temp++;
                index++;
            }
            if (index == needle.length()){
                return temp-needle.length();
            }
        }
        return -1;
    }
}