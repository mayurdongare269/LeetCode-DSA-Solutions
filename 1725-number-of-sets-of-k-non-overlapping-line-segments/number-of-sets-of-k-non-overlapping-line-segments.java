class Solution {

    static final int MOD = 1000000007;
    int[][] dp;

    public int solve(int n, int k, int i) {

        if (k == 0)
            return 1;

        if (i >= n)
            return 0;

        if (dp[k][i] != -1)
            return dp[k][i];

        long take = 0;

        // Start the segment from point i
        for (int j = i + 1; j < n; j++) {
            take = (take + solve(n, k - 1, j)) % MOD;
        }

        // Skip point i
        long skip = solve(n, k, i + 1);

        return dp[k][i] = (int)((take + skip) % MOD);
    }

    public int numberOfSets(int n, int k) {

        dp = new int[k + 1][n];

        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n, k, 0);
    }
}