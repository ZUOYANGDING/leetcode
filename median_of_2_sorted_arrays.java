class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int k1 = (l1+l2+1)/2;
        int k2 = (l1+l2+2)/2;
        double solution1 = findK(nums1, nums2, 0, 0, k1);
        double solution2 = findK(nums1, nums2, 0, 0, k2);
        return (solution1+solution2)/2.0;
    }
    
    int findK(int[] nums1, int[] nums2, int i, int j, int k) {
        if (i>=nums1.length) {
            return nums2[j+k-1];
        }
        if (j>=nums2.length) {
            return nums1[i+k-1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int a = (nums1.length > i+k/2-1) ? nums1[i+k/2-1] : Integer.MAX_VALUE;
        int b = (nums2.length > j+k/2-1) ? nums2[j+k/2-1] : Integer.MAX_VALUE;
        if (a < b) {
            return findK(nums1, nums2, i+k/2, j, k-k/2);
        } else {
            return findK(nums1, nums2, i, j+k/2, k-k/2);
        }

    }
}