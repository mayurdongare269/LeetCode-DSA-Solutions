public class Solution {
    public int CountServers(int[][] grid) {
        int m = grid.Length;
        int n = grid[0].Length;

        int[] rowCnt = new int[m];
        int[] colCnt = new int[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }

        int res = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && (rowCnt[i] > 1 || colCnt[j] > 1)) {
                    res++;
                } 
            }
        }

        return res;
    }
}