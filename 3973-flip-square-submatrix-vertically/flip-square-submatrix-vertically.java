class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i = 0; i < k / 2; i++) {
            int topRow = x + i;
            int botRow = x + k - 1 - i;

            for(int col = y; col < y + k; col++) {
                int temp = grid[topRow][col];
                grid[topRow][col] = grid[botRow][col];
                grid[botRow][col] = temp;
            }
        }

        return grid;
    }
}