class Solution { // tag hard but easy done... using DP

    int m, n;
    int[][] dp;
    static final int neg = -1000000000; 

    private int solve(int[] nums1, int[] nums2, int i , int j) {
        if(i == m || j == n) {
            return neg;
        }

        if(dp[i][j] != neg) {
            return dp[i][j];
        }

        int val = nums1[i] * nums2[j];

        int takeboth = val + solve(nums1, nums2, i+1, j+1);
        int skipNum1 = solve(nums1, nums2, i, j+1);
        int skipNum2 = solve(nums1, nums2, i+1, j);

        dp[i][j] = Math.max(val, 
                            Math.max(takeboth, Math.max(skipNum1, skipNum2))
                            
        );

        return dp[i][j];
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;

        dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = neg;
            }
        }
        return solve(nums1, nums2, 0, 0);
    }
}