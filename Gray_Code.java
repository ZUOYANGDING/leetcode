/*
Transfer from bitwise number to gray code is num^(num>>1)
*/
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<Math.pow(2, n); i++) {
            res.add((i>>1)^i);
        }
        return res;
    }
}