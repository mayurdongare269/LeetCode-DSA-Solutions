class Solution {

    static final int MOD = 1000000007;

    public int numberOfSets(int n, int K) {

        int[][] dp = new int[K + 1][n + 1];

        // Base case: 0 segments = 1 way
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int k = 1; k <= K; k++) {

            // Suffix sum of previous row
            int[] suffix = new int[n + 1];

            for (int i = n - 1; i >= 0; i--) {
                suffix[i] = (int) ((suffix[i + 1] + dp[k - 1][i]) % MOD);
            }

            for (int i = n - 1; i >= 0; i--) {

                // Take: sum of dp[k-1][j] for j = i+1 to n-1
                int take = suffix[i + 1];

                // Skip point i
                int skip = dp[k][i + 1];

                dp[k][i] = (take + skip) % MOD;
            }
        }

        return dp[K][0];
    }


    /*
    =====================================================
     2 APPROACHES
    =====================================================

    // 1️⃣ RECURSION + MEMOIZATION - done ...  (MIK video)
    //
    // int[][] memo;
    //
    // int solve(int n, int k, int i) {
    //
    //     if (k == 0)
    //         return 1;
    //
    //     if (i >= n)
    //         return 0;
    //
    //     if (memo[k][i] != -1)
    //         return memo[k][i];
    //
    //     long take = 0;
    //
    //     for (int j = i + 1; j < n; j++) {
    //         take = (take + solve(n, k - 1, j)) % MOD;
    //     }
    //
    //     long skip = solve(n, k, i + 1);
    //
    //     return memo[k][i] =
    //         (int)((take + skip) % MOD);
    // }


    // 2️⃣ BOTTOM-UP DP
    //
    // int[][] dp = new int[K + 1][n + 1];
    //
    // for (int i = 0; i < n; i++)
    //     dp[0][i] = 1;
    //
    // for (int k = 1; k <= K; k++) {
    //
    //     for (int i = n - 1; i >= 0; i--) {
    //
    //         int take = 0;
    //
    //         for (int j = i + 1; j < n; j++) {
    //             take = (take + dp[k - 1][j]) % MOD;
    //         }
    //
    //         int skip = dp[k][i + 1];
    //
    //         dp[k][i] = (take + skip) % MOD;
    //     }
    // }
    
    =====================================================
    */
}