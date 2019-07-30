class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (l1, l2) -> Integer.compare(l1[0], l2[0]));
        List<int[]> res = new ArrayList<>();
        int[] temp_interval = intervals[0];
        res.add(temp_interval);
        for (int[] interval: intervals) {
            if (interval[0] <= temp_interval[1]) {
                temp_interval[1] = Math.max(interval[1], temp_interval[1]);
                
            } else {
                temp_interval = interval;
                res.add(temp_interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    
}