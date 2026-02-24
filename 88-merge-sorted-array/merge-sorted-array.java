class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //1. Method 1
        // int l = 0; // left & right
        // int r = 0;
        // int arr[] = new int[n+m];
        // int idx = 0;

        // while(l < m && r < n) {
        //     if(nums1[l] <= nums2[r]) {
        //         arr[idx++] = nums1[l++];
        //     } else {
        //         arr[idx++] = nums2[r++];
        //     }
        // }

        // while(l < m) {
        //     arr[idx++] = nums1[l++];
        // }

        // while(r < n) {
        //     arr[idx++] = nums2[r++];
        // }

        // //imp step - convert arr to nums
        // for(int i = 0; i < m + n; i++) {
        //     nums1[i] = arr[i];
        // }

        //2. Method 2 optimal
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 has leftovers, copy them to nums1
        while(j >= 0) {
           nums1[k--] = nums2[j--];
        }

        // Remaining nums1 elements are already in correct position
    }
}