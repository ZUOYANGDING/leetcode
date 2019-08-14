/*
Similar to problem Largest Rectangle in Histrogram. Regard each line as the bottom of the histrograms
then build if matrix[i][j]==0, the height is 0, else height is the previous histrogram build by last line
plus one. Therefore, number of lines is the number of sub problems of "Largest Rectangle in Histrogram". 
*/ 

Class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0) {
            return 0;
        }
        
        int[] heights = new int[matrix[0].length];
        int res = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                heights[j] = (matrix[i][j]=='0') ? 0 : (1 + heights[j]);
            }
            res = Math.max(res, findSolution(heights));
        }
        return res;
    }
    
    public int findSolution(int[] heights) {
        int res = 0;
        int[] new_heights = new int[heights.length+1];
        Stack<Integer> increment = new Stack<>();
        new_heights = Arrays.copyOf(heights, heights.length+1);
        int index = 0;
        while (index < new_heights.length) {
            if (increment.isEmpty() ||  new_heights[increment.peek()] <= new_heights[index]) {
                increment.push(index);
                index++;
            } else {
                int height = new_heights[increment.pop()];
                res = Math.max(res, height * (increment.isEmpty() ? index : index-increment.peek()-1));
            }
        }
        return res;
    }
}