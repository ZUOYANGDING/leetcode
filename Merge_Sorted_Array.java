class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1;
        int index2 = n-1;
        int index_end = m+n-1;
        while (index_end>=0 && index1>=0 && index2>=0) {
            if (nums2[index2] > nums1[index1]) {
                nums1[index_end] = nums2[index2];
                index2--;
                index_end--;
            } else {
                nums1[index_end] = nums1[index1];
                nums1[index1] = 0;
                index1--;
                index_end--;
            }
        }
        if (index2>=0) {
            for (int i=0; i<=index2; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
}