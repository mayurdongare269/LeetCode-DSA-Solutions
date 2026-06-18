class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        // Create empty chess board
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, ans, n);

        return ans;
    }

    private void solve(int col, char[][] board, List<List<String>> ans, int n) {

        // All queens placed successfully
        if(col == n) {

            List<String> temp = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        // Try placing queen in every row of current column
        for(int row = 0; row < n; row++) {

            if(isSafe(row, col, board, n)) {

                board[row][col] = 'Q'; // place queen

                solve(col + 1, board, ans, n);

                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {

        int dupRow = row;
        int dupCol = col;

        // Check upper-left diagonal
        while(row >= 0 && col >= 0) {

            if(board[row][col] == 'Q') {
                return false;
            }

            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        // Check left side
        while(col >= 0) {

            if(board[row][col] == 'Q') {
                return false;
            }

            col--;
        }

        row = dupRow;
        col = dupCol;

        // Check lower-left diagonal
        while(row < n && col >= 0) {

            if(board[row][col] == 'Q') {
                return false;
            }

            row++;
            col--;
        }

        return true;
    }
}