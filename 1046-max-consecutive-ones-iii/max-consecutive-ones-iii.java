class Solution {
    public int longestOnes(int[] nums, int k) {
        // method - 1 : brute O(n2)
        // int n = nums.length;
        // int maxLen = 0;

        // for(int i = 0; i < n; i++) {
        //     int zeros = 0;
        //     for(int j = i; j < n; j++) {
        //         if(nums[j] == 0) {
        //             zeros++;
        //         }

        //         if(zeros <= k) {
        //             int len = j - i + 1;
        //             maxLen = Math.max(maxLen, len);
        //         } else {
        //             break;
        //         }
        //     }
        // }

        // return maxLen;

        // Method- 2: better O(2n)
        int n = nums.length;
        int l = 0, r = 0, maxLen = 0;
        int zeros = 0;

        while(r < n) {
            if(nums[r] == 0) zeros++;

            while(zeros > k) { // add if then its become optiomal O(n)
                if(nums[l] == 0) zeros--;
                l++;
            }

            if(zeros <= k) {
                int len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }

            r++;
        }

        return maxLen;
    }
}