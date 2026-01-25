class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;   // special case

        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i + k - 1 < n; i++) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }

        return minDiff;
    }
}
