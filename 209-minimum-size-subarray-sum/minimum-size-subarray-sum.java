class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int l = 0, r = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while(r < n) {
            sum += nums[r];

            while(sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                
                sum -= nums[l];
                l++;
            }

            r++;
        }

        if(minLen == Integer.MAX_VALUE) {
            return 0;
        }

        return minLen;
    }
}