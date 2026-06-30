class Solution {
    // // (Brute Force + Recursion)

    // boolean isPalindrome(String s, int i, int j) {

    //     if (i >= j)
    //         return true;

    //     if (s.charAt(i) == s.charAt(j))
    //         return isPalindrome(s, i + 1, j - 1);

    //     return false;
    // }

    // public String longestPalindrome(String s) {

    //     int maxLen = 0;
    //     int start = 0;

    //     for (int i = 0; i < s.length(); i++) {

    //         for (int j = i; j < s.length(); j++) {

    //             if (isPalindrome(s, i, j)) {

    //                 if (j - i + 1 > maxLen) {
    //                     maxLen = j - i + 1;
    //                     start = i;
    //                 }
    //             }
    //         }
    //     }

    //     return s.substring(start, start + maxLen);
    // }

    int[][] dp = new int[1001][1001];

    boolean solve(String s, int i, int j) {

        if (i >= j)
            return true;

        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        if (s.charAt(i) == s.charAt(j))
            return (dp[i][j] = solve(s, i + 1, j - 1) ? 1 : 0) == 1;

        dp[i][j] = 0;

        return false;
    }

    public String longestPalindrome(String s) {

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                if (solve(s, i, j)) {

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}