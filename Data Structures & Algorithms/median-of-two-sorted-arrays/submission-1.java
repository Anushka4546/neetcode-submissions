class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedian(nums2, nums1);
        } else {
            return findMedian(nums1, nums2);
        }
    }

    private double findMedian(int[] nums1, int[] nums2) {
        int numbersToBePicked = (nums1.length + nums2.length + 1) / 2;
        int low = 0, high = nums1.length;

        while(low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = numbersToBePicked - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(mid1 < nums1.length) {
                r1 = nums1[mid1];
            }

            if(mid2 < nums2.length) {
                r2 = nums2[mid2];
            }

            if(mid1 - 1 < nums1.length && mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            } 

            if(mid2 - 1 < nums2.length && mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }

            if(l1 <= r2 && l2 <= r1) {
                if((nums1.length + nums2.length) % 2 == 1) {
                    return (double)Math.max(l1, l2);
                } else {
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                }
            } else if(l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0.0;
    }
}
