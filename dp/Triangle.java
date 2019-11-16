// Since from the one row to the row below it, we can only move to the adjacent element, we just need
// to sum up the triangle[i][j] with min(triangle[i-1][j], triangle[i-1], [j-1]). Then the min value
// in last row will be the answer.
// The dp equation is:
//              triangle[i, j] += Min(triangle[i-1][j], triangle[i-1], [j-1])
// For the first and last elements of each row, the dp equation is:
//              triangle[i, j] += triangle[i-1][j],         when j==0
//              triangle[i, j] += triangle[i-1][j-1]        when j==size of the row-1

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        int row = triangle.size();
        for (int i=1; i<row; i++) {
            List current = triangle.get(i);
            List pre = triangle.get(i-1);
            for (int j=0; j<current.size(); j++) {
                if (j == 0) {
                    current.set(0, ((int)current.get(0) + (int)pre.get(0)));
                } else if (j == current.size()-1) {
                    current.set(j, ((int)current.get(j) + (int)pre.get(pre.size()-1)));
                } else {
                    int min = Math.min((int)pre.get(j), (int)pre.get(j-1));
                    current.set(j, ((int)current.get(j) + min));
                }
            }
        }
        List last = triangle.get(row-1);
        int re = (int)last.get(0);
        for (int i=1; i<last.size(); i++) {
            if ((int)last.get(i) <= re) {
                re = (int)last.get(i);
            }
        }
        return re;
    }
}