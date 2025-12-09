class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int m = nums1.length, n = nums2.length;

        int mid = (m + n) / 2;
        int nums1Idx = 0, nums2Idx = 0;
        int[] nums = new int[m + n];
        for(int i = 0; i <= mid; i++) {
            if(nums1Idx < m && nums2Idx < n)
                nums[i] = nums1[nums1Idx] > nums2[nums2Idx] ? nums2[nums2Idx++] : nums1[nums1Idx++];
            else if(nums1Idx < m) nums[i] = nums1[nums1Idx++];
            else nums[i] = nums2[nums2Idx++];
        }
        
        if(mid == 0) return (double)nums[mid];
        return (m + n) % 2 == 0 ? ((double)nums[mid - 1] + (double)nums[mid]) / 2 : (double)nums[mid];
    }
}