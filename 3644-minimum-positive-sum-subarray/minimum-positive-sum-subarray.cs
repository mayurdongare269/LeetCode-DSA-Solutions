
public class Solution {
    public int MinimumSumSubarray(IList<int> nums, int l, int r) {
        int n = nums.Count;
        int[] prefix = new int[n + 1];

        // prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int minSum = int.MaxValue;

        for (int i = 0; i < n; i++) {
            for (int len = l; len <= r && i + len <= n; len++) {

                int sum = prefix[i + len] - prefix[i];

                if (sum > 0) {
                    minSum = Math.Min(minSum, sum);
                }
            }
        }

        return minSum == int.MaxValue ? -1 : minSum;
    }
}