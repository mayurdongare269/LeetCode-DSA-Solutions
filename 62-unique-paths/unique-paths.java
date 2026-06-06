class Solution {
    public int uniquePaths(int m, int n) {

        // // memoization  - top down means last to start...
        // int dp[][] = new int[m][n];

        // for(int[] row : dp) {
        //     Arrays.fill(row , -1);
        // }

        // return func(m-1, n-1, dp);

        // tabulation: bottom up means start to end...
        int[][] dp = new int[m+1][n+1]; // always take note that if you add +1 then make sure to add everywhere +1 in function and for return call with -1...
        return tabFun(m-1, n-1, dp);
    }

    public static int func(int i, int j, int[][] dp) {// memoization
        if(i == 0 && j == 0) return 1; 

        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = func(i-1, j, dp);
        int left = func(i, j - 1, dp);

        return dp[i][j] = up + left;
    }

    //tabulation
    public static int tabFun(int n, int m, int[][] dp) { //i take n as row and m as col..
        //initialize 
        for(int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        }

        for(int j = 0; j < m+1; j++) {
            dp[0][j] = 1;
        }

        //loop
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                int up = dp[i-1][j];
                int left = dp[i][j-1];
                dp[i][j] = up + left;
            }
        }

        return dp[n][m];
    }
}