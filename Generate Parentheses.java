//Add "(" and ")" recursivly, count down the number of "(" as left  and ")" as right. If left > right, means there
//are situation ")(", which is illegal, just return. if left==right==0, which means we find a possible solution
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> re = new ArrayList<>();
        int left = n;
        int right = n;
        String out = "";
        recursiveBuild(left, right, out, re);
        return re;
    }
    
    public void recursiveBuild(int left, int right, String out, List<String> re){
        if (left>right){
            return;
        }
        if (left==0 && right==0){
            re.add(out);
            return;
        }
        if (left > 0){
            //System.out.println("in left" + String.valueOf(left) + String.valueOf(right) + out);
            recursiveBuild(left-1, right, out+"(", re);
        }
        if (right > 0) {
            //System.out.println("int right" + String.valueOf(left) + String.valueOf(right) + out);
            recursiveBuild(left, right-1, out+")", re);
        }
    }
}