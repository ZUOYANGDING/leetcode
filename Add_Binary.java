class Solution {
    public String addBinary(String a, String b) {
        List<Character> l = new ArrayList<>();
        int travel = 0;
        int la = a.length()-1;
        int lb = b.length()-1;
        int l1 = 0;
        if (la < lb) {
            l1 = lb;
            for (int i=0; i<lb-la; i++) {
                a = "0" + a;
            }
        } else if (la > lb){
            l1 = la;
            for (int i=0; i<la-lb; i++) {
                b = "0" + b;
            }
        } else {
            l1 = la;
        }
        while (l1>=0) {
            int temp = (Character.getNumericValue(a.charAt(l1)) + Character.getNumericValue(b.charAt(l1)) + travel) % 2;
            travel = (Character.getNumericValue(a.charAt(l1)) + Character.getNumericValue(b.charAt(l1)) + travel) / 2;
            System.out.println(travel);
            l.add((char)((temp)+'0'));
            l1--;
        }
        if (travel != 0) {
            l.add((char)((travel)+'0'));
        }
        String temp = "";
        for (int i=l.size()-1; i>=0; i--) {
            temp += l.get(i);
        }
        return temp;
    }
}