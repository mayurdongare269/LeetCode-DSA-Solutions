class Solution {
    public int[] leftRightDifference(int[] nums) {
        // int n = nums.length;

        // int[] left = new int[n];
        // int[] right = new int[n];

        // left[0] = 0;
        // for(int i = 1; i < n; i++) {
        //     left[i] = left[i-1] + nums[i-1];
        // }

        // right[n-1] = 0;
        // for(int i = n-2; i >= 0; i--) {
        //     right[i] = right[i+1] + nums[i+1];
        // }

        // int[] ans = new int[n];
        // for(int i = 0; i < n; i++) {
        //     ans[i] = Math.abs(left[i] - right[i]);
        // }

        // return ans;


        //optimized.. solved using only one array and O(1) extra space

        int n = nums.length;

        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        int[] ans = new int[n];

        int leftSum = 0;

        for(int i = 0; i < n; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            ans[i] = Math.abs(leftSum - rightSum);

            leftSum += nums[i];
        }

        return ans;
    }
}