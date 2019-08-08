class Solution {
    public boolean isNumber(String s) {
        if (s==null || s.length()==0){
            return false;
        }
        int head = 0;
        int tail = s.length()-1;
        while (head < s.length() && s.charAt(head)==' ')         {
            head++;
        }
        while (tail >= 0 && s.charAt(tail)==' ') {
            tail--;
        }
//         check "      "
        System.out.println(head +" "+tail);
        if (head>tail) {
            return false;
        }
//         check .
        int flag = 0;
        for (int i=head; i<=tail ; i++) {
            if (s.charAt(i) == '.') {
                flag++;
            }
        }
        if (flag > 1) {
            return false;
        }
//         check e/E;
        flag = 0;
        for (int i=head; i<=tail; i++) {
            if (s.charAt(i)=='e' || s.charAt(i)=='E'){
                flag++;
            }
        }
        if (flag > 1) {
            return false;
        }
//         check others
        for (int i=head; i<=tail; i++) {
            if (s.charAt(i) == 'e') {
                if (i==head || i==tail) {
                    return false;
                }
                if (((i-1)>=head && s.charAt(i-1)>='0' && s.charAt(i-1)<='9') || ((i-2)>=head &&                              s.charAt(i-2)>='0' && s.charAt(i-2)<='9')) {
                   if (((i+1)<=tail && s.charAt(i+1)>='0' && s.charAt(i+1)<='9') || ((i+2)<=tail &&                          s.charAt(i+2)>='0' && s.charAt(i+2)<='9')) {
                        continue;
                   } else {
                       return false;
                   }
                } else {
                    return false;
                }
            } else if (s.charAt(i)=='+' || s.charAt(i)=='-') {
                if (i != head && (s.charAt(i-1)!= 'e' && s.charAt(i-1)!= 'E')){
                    System.out.println("here");
                    return false;
                }
                if ((i+1)<=tail && s.charAt(i+1)>='0' && s.charAt(i+1)<='9') {
                    continue;
                } else if ((i+2)<=tail && s.charAt(i+2)>='0' && s.charAt(i+2)<='9') {
                    continue;
                }  else {
                    return false;
                }
            } else if (s.charAt(i) == '.') {
                int p1 = s.indexOf('e');
                int p2 = s.indexOf('E');
                if (p1 != -1) {
                    if (i > p1) {
                        return false;
                    }
                } else if (p2 != -1) {
                    if (i > p2) {
                        return false;
                    }
                }
                if ((i-1)>=head && s.charAt(i-1)>='0' && s.charAt(i-1)<='9') {
                    continue;
                } else if ((i+1)<=tail && s.charAt(i+1)>='0' && s.charAt(i+1)<='9') {
                    continue;
                } else {
                    return false;
                }
            } else if (s.charAt(i)>='0' && s.charAt(i)<='9') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}