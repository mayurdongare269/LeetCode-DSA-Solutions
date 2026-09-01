class Solution {
    
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                
                if (grid[row][col] == '1') {
                    count++;
                    dfs(row, col, grid);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int row, int col, char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        // Boundary check
        if (row < 0 || row >= n || col < 0 || col >= m) {
            return;
        }
        
        // If water or already visited
        if (grid[row][col] == '0') {
            return;
        }
        
        // Mark as visited
        grid[row][col] = '0';
        
        // Go up
        dfs(row - 1, col, grid);
        
        // Go down
        dfs(row + 1, col, grid);
        
        // Go left
        dfs(row, col - 1, grid);
        
        // Go right
        dfs(row, col + 1, grid);
    }
}

// BFS
// class Pair {
//     int first;
//     int second;

//     public Pair(int first, int second) {
//         this.first = first;
//         this.second = second;
//     }
// }

// class Solution {

//     private void bfs(int row, int col, int[][] vis, char[][] grid) {

//         int n = grid.length;
//         int m = grid[0].length;

//         Queue<Pair> q = new LinkedList<>();

//         // Mark starting cell as visited
//         vis[row][col] = 1;
//         q.add(new Pair(row, col));

//         while (!q.isEmpty()) {

//             int r = q.peek().first;
//             int c = q.peek().second;

//             q.remove();

//             // Traverse all 8 neighbouring cells
//             for (int delRow = -1; delRow <= 1; delRow++) {

//                 for (int delCol = -1; delCol <= 1; delCol++) {

//                     int nrow = r + delRow;
//                     int ncol = c + delCol;

//                     // Check boundaries and whether it is unvisited land
//                     if (nrow >= 0 && nrow < n &&
//                         ncol >= 0 && ncol < m &&
//                         grid[nrow][ncol] == '1' &&
//                         vis[nrow][ncol] == 0) {

//                         vis[nrow][ncol] = 1;
//                         q.add(new Pair(nrow, ncol));
//                     }
//                 }
//             }
//         }
//     }

//     public int numIslands(char[][] grid) {

//         int n = grid.length;
//         int m = grid[0].length;

//         int[][] vis = new int[n][m];

//         int count = 0;

//         for (int row = 0; row < n; row++) {

//             for (int col = 0; col < m; col++) {

//                 if (vis[row][col] == 0 &&
//                     grid[row][col] == '1') {

//                     count++;

//                     bfs(row, col, vis, grid);
//                 }
//             }
//         }

//         return count;
//     }
// }