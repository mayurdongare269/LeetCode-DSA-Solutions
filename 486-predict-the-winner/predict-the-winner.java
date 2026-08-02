class Solution {

    // ============================================================
    // Approach 1: Basic Recursion (Maximum Score)
    // Time Complexity: O(2^N)
    // Space Complexity: O(N)
    // ============================================================

    /*
    public int solve(int[] nums, int i, int j) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            return nums[i];
        }

        int takeLeft = nums[i] + Math.min(
                solve(nums, i + 2, j),
                solve(nums, i + 1, j - 1)
        );

        int takeRight = nums[j] + Math.min(
                solve(nums, i, j - 2),
                solve(nums, i + 1, j - 1)
        );

        return Math.max(takeLeft, takeRight);
    }

    public boolean predictTheWinner(int[] nums) {

        int totalScore = 0;
        for (int num : nums) {
            totalScore += num;
        }

        int player1 = solve(nums, 0, nums.length - 1);
        int player2 = totalScore - player1;

        return player1 >= player2;
    }
    */


    // ============================================================
    // Approach 2: Memoization
    // Time Complexity: O(N^2)
    // Space Complexity: O(N^2)
    // ============================================================

    /*
    int[][] dp;

    public int solve(int[] nums, int i, int j) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            return nums[i];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int takeLeft = nums[i] + Math.min(
                solve(nums, i + 2, j),
                solve(nums, i + 1, j - 1)
        );

        int takeRight = nums[j] + Math.min(
                solve(nums, i, j - 2),
                solve(nums, i + 1, j - 1)
        );

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int totalScore = 0;
        for (int num : nums) {
            totalScore += num;
        }

        int player1 = solve(nums, 0, n - 1);
        int player2 = totalScore - player1;

        return player1 >= player2;
    }
    */


    // ============================================================
    // Approach 3: Optimal (Score Difference)
    // Time Complexity: O(2^N)
    // Space Complexity: O(N)
    // ============================================================

    // Returns the score difference (Player1 - Player2)
    public int solve(int[] nums, int i, int j) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            return nums[i];
        }

        int takeLeft = nums[i] - solve(nums, i + 1, j);
        int takeRight = nums[j] - solve(nums, i, j - 1);

        return Math.max(takeLeft, takeRight);
    }

    public boolean predictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1) >= 0;
    }
}