class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //1. Method 1
        int l = 0; // left & right
        int r = 0;
        int arr[] = new int[n+m];
        int idx = 0;

        while(l < m && r < n) {
            if(nums1[l] <= nums2[r]) {
                arr[idx++] = nums1[l++];
            } else {
                arr[idx++] = nums2[r++];
            }
        }

        while(l < m) {
            arr[idx++] = nums1[l++];
        }

        while(r < n) {
            arr[idx++] = nums2[r++];
        }

        //imp step - convert arr to nums
        for(int i = 0; i < m + n; i++) {
            nums1[i] = arr[i];
        }
    }
}