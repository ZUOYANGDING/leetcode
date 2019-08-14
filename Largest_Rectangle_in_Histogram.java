/*
Normal solution is find the shortest board from (i, j) and compare the area, but cost O(n^2)
For O(n), we need to maintain a incremental stack, to store the index whose height is incremental.
If we find heights[i] > heights[stack.top()], we need to calculate the areas until the stack empty 
or heights[stack.top()] < heights[i]. The reason is the height of the area only depends on the lower
height during the process. 

*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> increment = new Stack<>();
        int[] new_heights = new int[heights.length+1];
        new_heights = Arrays.copyOf(heights, heights.length+1);
        int index = 0;
        while (index < new_heights.length) {
            if (increment.isEmpty() ||  new_heights[increment.peek()] < new_heights[index]) {
                increment.push(index);
                index++;
            } else {
                int height = new_heights[increment.pop()];
                res = Math.max(res, height * (increment.isEmpty() ? index : (index-increment.peek()-1)));   
            }
        }
        return res;
    }
}