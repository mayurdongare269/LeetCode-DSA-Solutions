class Solution {
    public int findMin(int[] nums) { // remeber it ... low < high or see YT for low <= high approach

       // // method 1: not a striver method
        // int low = 0, high = nums.length - 1;

        // while (low < high) {
        //     int mid = low + (high - low) / 2;

        //     // If mid element is greater than the rightmost, min is in right half
        //     if (nums[mid] > nums[high]) {
        //         low = mid + 1;
        //     } 
        //     // Else, the min is at mid or in the left half
        //     else {
        //         high = mid;
        //     }
        // }

        // // At the end of loop, low == high and pointing to the smallest element
        // return nums[low];


        //Method2: striver method YT
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                high = mid - 1;
                ans = Math.min(ans, nums[mid]);
            }
        }

        return ans;
       
    }
}
