public class Solution {
    public int UniquePaths(int[][] grid) {

        const long MOD = 1000000007;

        int m = grid.Length;
        int n = grid[0].Length;

        long[,] right = new long[m, n];
        long[,] down = new long[m, n];

        long ans = 0;

        right[0, 0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                long r = right[i, j];
                long d = down[i, j];

                if (grid[i][j] == 0) {

                    long ways = (r + d) % MOD;

                    if (i == m - 1 && j == n - 1) {
                        ans = ways;
                        continue;
                    }

                    // Move Right
                    if (j + 1 < n) {
                        right[i, j + 1] =
                            (right[i, j + 1] + ways) % MOD;
                    }

                    // Move Down
                    if (i + 1 < m) {
                        down[i + 1, j] =
                            (down[i + 1, j] + ways) % MOD;
                    }
                }
                else {

                    // Mirror: Right -> Down
                    if (i + 1 < m) {
                        down[i + 1, j] =
                            (down[i + 1, j] + r) % MOD;
                    }

                    // Mirror: Down -> Right
                    if (j + 1 < n) {
                        right[i, j + 1] =
                            (right[i, j + 1] + d) % MOD;
                    }
                }
            }
        }

        return (int)ans;
    }
}