/*
Consideration: the amount of water trapping at at height[i] is decided by the min(max(left), max(right))
of this position. Therefore, go through from left to right of the height array and store the max(left) of
index i, then go through from right to left of the height array and store the max(right) of index i. Finally,
for each index i, choose the min of max(left) and max(right), if the result great then the height[i],
min(max(left), max(right)) - height[i] is the amount of water that index i can traps. 
*/
class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int[] temp = new int[size];
        int max = 0;
        for (int i=0; i<size; i++) {
            temp[i] = max;
            max = Math.max(max, height[i]);
        }
        int sum = 0;
        max = 0;
        for (int i=size-1; i>=0; i--) {
            temp[i] = Math.min(temp[i], max);
            max = Math.max(height[i], max);
            if (height[i] < temp[i]) {
                sum += (temp[i] - height[i]);
            }
        }
        return sum;
    }
}